import { initializeApp } from 'firebase/app';
import {
    browserLocalPersistence,
    getAuth,
    setPersistence,
} from 'firebase/auth';
const firebaseConfig = {
    apiKey: 'AIzaSyDlACTbChFazfaFfJDuOv-Q74C9E7isf5k',
    authDomain: 'medicine-tracker-systemzombies.firebaseapp.com',
    projectId: 'medicine-tracker-systemzombies',
    storageBucket: 'medicine-tracker-systemzombies.appspot.com',
    messagingSenderId: '848483661781',
    appId: '1:848483661781:web:320e5dbb7ad01dac6c2f5c',
    measurementId: 'G-YR1YCVNYHF',
};

//Initialise firebase
const app = initializeApp(firebaseConfig);
const auth = getAuth(app);

setPersistence(auth, browserLocalPersistence);
export { auth };
