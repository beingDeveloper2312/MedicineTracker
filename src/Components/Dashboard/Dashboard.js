import {
    Box,
    Drawer,
    Typography,
    Toolbar,
    IconButton,
    Button,
} from '@mui/material';

import MenuIcon from '@mui/icons-material/Menu';
import AddIcon from '@mui/icons-material/Add';
import CancelIcon from '@mui/icons-material/Cancel';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';
import CloseIcon from '@mui/icons-material/Close';
import DoneIcon from '@mui/icons-material/Done';
import { auth } from '../../Firebase/Firebase';
import { onAuthStateChanged } from 'firebase/auth';
import { useNavigate } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { useRecoilState } from 'recoil';
import { currentUserState } from '../../Atoms/userAtom';
import './Dashboard.css';
import Side from './Side';
const Dashboard = () => {
    const navigate = useNavigate();
    const [open, setOpen] = useState(false);
    const [currentUser, setCurrentUser] = useRecoilState(currentUserState);
    useEffect(() => {
        onAuthStateChanged(auth, (user) => {
            if (!user) {
                navigate('/login');
            } else {
                const { displayName, photoURL, uid } = user;
                setCurrentUser({
                    uid,
                    displayName,
                    photoURL,
                });
            }
        });
    }, []);

    const handleDrawerOpen = () => {
        setOpen(!open);
    };

    return (
        <Box className="dash">
            <header className="dash__appbar">
                <IconButton
                    aria-label="open drawer"
                    onClick={handleDrawerOpen}
                    edge="start"
                >
                    {!open ? (
                        <MenuIcon sx={{ fontSize: '3rem', color: '#fff' }} />
                    ) : (
                        <CloseIcon sx={{ fontSize: '3rem', color: '#fff' }} />
                    )}
                </IconButton>
                <h1 className="appbar--heading"> Medicine Tracker</h1>
            </header>
            <main className="dash__content">
                {open && <Side />}
                <div className="dash__post">hello</div>
            </main>
        </Box>
    );
};

export default Dashboard;
