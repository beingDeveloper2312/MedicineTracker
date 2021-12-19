import {
    Box,
    Drawer,
    Typography,
    Toolbar,
    IconButton,
    Button,
} from '@mui/material';

import MenuIcon from '@mui/icons-material/Menu';
import CancelIcon from '@mui/icons-material/Cancel';
import CloseIcon from '@mui/icons-material/Close';
import DoneIcon from '@mui/icons-material/Done';
import { auth } from '../../Firebase/Firebase';
import { onAuthStateChanged } from 'firebase/auth';
import { useNavigate } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { useRecoilState } from 'recoil';
import { medList } from '../../Atoms/medAtom';
import { currentUserState } from '../../Atoms/userAtom';
import './Dashboard.css';
import Side from './Side';
import Post from './Post';
import MedList from './MedList';
const Dashboard = () => {
    const navigate = useNavigate();
    const [open, setOpen] = useState(false);
    const [currentUser, setCurrentUser] = useRecoilState(currentUserState);
    const [meds, addMedList] = useRecoilState(medList);
    useEffect(() => {
        console.log(meds);
    }, [meds, addMedList]);
    useEffect(() => {
        onAuthStateChanged(auth, (user) => {
            if (!user) {
                navigate('/login');
            } else {
                const { displayName, photoURL, uid, email } = user;
                setCurrentUser({
                    uid,
                    displayName,
                    photoURL,
                    email,
                });
            }
        });
    }, []);

    const handleDrawerOpen = () => {
        setOpen(!open);
    };

    return (
        <div className="dash">
            <header className="dash__appbar">
                <IconButton aria-label="open drawer" onClick={handleDrawerOpen}>
                    {!open ? (
                        <MenuIcon style={{ fontSize: '30px', color: '#fff' }} />
                    ) : (
                        <CloseIcon
                            style={{ fontSize: '30px', color: '#fff' }}
                        />
                    )}
                </IconButton>
                <h1 className="appbar--heading"> Medicine Tracker</h1>
            </header>
            <main className="dash__content">
                {open && <Side />}
                <div className="dash__med--list">
                    <div className="dash__medicines">
                        <h1 className="dash__heading"> Your Medications</h1>
                        <MedList />
                    </div>
                    <Post />
                </div>
            </main>
        </div>
    );
};

export default Dashboard;
