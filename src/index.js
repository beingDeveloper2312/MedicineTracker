import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import Login from './Components/Login/Login';
import Dashboard from './Components/Dashboard/Dashboard';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { RecoilRoot } from 'recoil';

ReactDOM.render(
    <React.StrictMode>
        <RecoilRoot>
            <BrowserRouter>
                <Routes>
                    <Route exact path="/" element={<App />} />
                    <Route path="/login" element={<Login />} />
                    <Route exact path="/dashboard" element={<Dashboard />} />
                </Routes>
            </BrowserRouter>
        </RecoilRoot>
    </React.StrictMode>,
    document.getElementById('root')
);
