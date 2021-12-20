import React from "react";
import './HeadMob.css'
import Image from "./HeadingAssets/Frame 2.svg";
import Image1 from "./HeadingAssets/element.svg";
import { Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.css';
import Button from 'react-bootstrap/Button';
export const HeadMob = () => {
    return (
        <div>
            <img src={Image1} alt="dots" className = "dots" width="9%"></img>
        <div className="head-mob">
            
            <br />
            <img src={Image} className="head-img" alt="head-img" width="50%" ></img>
            <h1>Medicare reminds you before your meficine time, keeps track of your stock and dosage, so that you never miss on your medicine</h1>
            <br/>
            <Button variant="dark" size="lg">
            <Link to="login" className="login-btn">
                    Register / Login
                    </Link>
            </Button>
        </div>
        </div>
    )
}