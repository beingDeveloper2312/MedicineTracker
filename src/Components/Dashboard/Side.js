import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import DashboardIcon from '@mui/icons-material/Dashboard';
import AddShoppingCartIcon from '@mui/icons-material/AddShoppingCart';
import ExitToAppIcon from '@mui/icons-material/ExitToApp';
import MedicalServicesIcon from '@mui/icons-material/MedicalServices';
import './Dashboard.css';
import { auth } from '../../Firebase/Firebase';
import { signOut } from 'firebase/auth';
import { useNavigate } from 'react-router-dom';
import { useRecoilValue } from 'recoil';
import { currentUserState } from '../../Atoms/userAtom';
const Side = () => {
    const navigate = useNavigate();
    const currentUser = useRecoilValue(currentUserState);
    const handleLogout = (e) => {
        signOut(auth)
            .then(() => {
                console.log('Logout successful');
                navigate('/login');
            })
            .catch((error) => console.log(error));
    };
    return (
        <aside className="dash__drawer">
            <div className="drawer__header">
                <img
                    className="profile__image"
                    src={currentUser?.photoURL}
                    alt={currentUser?.displayName}
                />
                <h1 className="profile__name">{currentUser?.displayName}</h1>
                <p>{currentUser?.email}</p>
            </div>
            <List disablePadding className="drawer__menu">
                <ListItem disablePadding>
                    <ListItemButton className={`menu--button`}>
                        <ListItemIcon className="menu--icon">
                            <DashboardIcon
                                sx={{ fontSize: '3rem', color: '#000' }}
                            />
                        </ListItemIcon>
                        <ListItemText
                            disableTypography
                            sx={{
                                fontSize: '1.5rem',
                            }}
                            primary="Dashboard"
                        />
                    </ListItemButton>
                </ListItem>
                <ListItem disablePadding>
                    <ListItemButton className={`menu--button`}>
                        <ListItemIcon className="menu--icon">
                            <MedicalServicesIcon
                                sx={{ fontSize: '3rem', color: '#000' }}
                            />
                        </ListItemIcon>
                        <ListItemText
                            disableTypography
                            sx={{
                                fontSize: '1.5rem',
                            }}
                            primary="Medication"
                        />
                    </ListItemButton>
                </ListItem>
                <ListItem disablePadding>
                    <ListItemButton className={`menu--button`}>
                        <ListItemIcon className="menu--icon">
                            <AddShoppingCartIcon
                                sx={{ fontSize: '3rem', color: '#000' }}
                            />
                        </ListItemIcon>
                        <ListItemText
                            disableTypography
                            sx={{
                                fontSize: '1.5rem',
                            }}
                            primary="Buy Medicines"
                        />
                    </ListItemButton>
                </ListItem>
                <ListItem disablePadding>
                    <ListItemButton
                        className={`menu--button`}
                        onClick={handleLogout}
                    >
                        <ListItemIcon className="menu--icon">
                            <ExitToAppIcon
                                sx={{ fontSize: '3rem', color: '#000' }}
                            />
                        </ListItemIcon>
                        <ListItemText
                            disableTypography
                            sx={{
                                fontSize: '1.5rem',
                            }}
                            primary="Logout"
                        />
                    </ListItemButton>
                </ListItem>
            </List>
        </aside>
    );
};

export default Side;
