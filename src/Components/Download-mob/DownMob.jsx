import React from "react";
import './DownMob.css'
import Image from "./HeadingAssets/Frame 2.svg";
import Image1 from "./HeadingAssets/element.svg";
import { Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.css';
import Button from 'react-bootstrap/Button';
export const DownMob = () => {
    return (
        <div id = "Download">
            {/* <img src={Image1} alt="dots" className = "dots" width="9%"></img> */}
        <div className="head-mob">
            
            <br />
            <img src={Image} className="head-img" alt="head-img" width="50%" ></img>
            <h1>Get our app today to access all features in your mobile</h1>
            <br/>
            <Button variant="dark" size="lg">
            <a href = "https://drive.google.com/drive/u/0/folders/1JQLu0yngwdlEQcPHL6XpNIwFgaY86Hju" className="download-btn">
                    Download
                    </a>
            </Button>
        </div>
        </div>
    )
}