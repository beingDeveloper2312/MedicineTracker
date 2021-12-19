import './Login.css';
import '../../App.css';
import { auth } from '../../Firebase/Firebase';
import { Button } from '@mui/material';
import GoogleIcon from '@mui/icons-material/Google';
import { useNavigate } from 'react-router-dom';
import {
    signInWithPopup,
    GoogleAuthProvider,
    onAuthStateChanged,
} from 'firebase/auth';
const Login = () => {
    let navigate = useNavigate();

    onAuthStateChanged(auth, (user) => {
        if (user) {
            navigate('/dashboard');
        }
    });

    const handleLogin = () => {
        const provider = new GoogleAuthProvider();
        signInWithPopup(auth, provider)
            .then((result) => {
                //Sign in user info
                if (result.user) {
                    //set the user state as result.user
                    //navigate to dashboard
                    navigate('/dashboard');
                }
            })
            .catch((error) => console.log(error));
    };
    return (
        <div className="login__section">
            <Button
                onClick={handleLogin}
                style={{
                    display: 'flex',
                    justifyContent: 'space-around',
                    alignItems: 'center',
                    minWidth: '20vw',
                    minHeight: '5vw',
                    fontSize: 'clamp(20px, 1vw, 40px',
                }}
                variant="contained"
                size="large"
            >
                SIGN IN THROUGH GOOGLE
                {
                    <GoogleIcon
                        style={{ marginLeft: 10, width: 30, height: 30 }}
                    />
                }
            </Button>
        </div>
    );
};

export default Login;
