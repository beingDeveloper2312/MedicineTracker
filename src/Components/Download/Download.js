import React from "react";
import Image from "./HeadingAssets/appD.svg";
import Image1 from "./HeadingAssets/element.svg";
import "./Download.css";
const Download = () => {
    return (
        <div id = "Download" className="download">
            <img src={Image1} alt="dots" className = "dots" width="6%"></img>
            <div className="heading">
               
                <div className="head-content">
                    <h1 className="head">Download Our App</h1>
                    <p>Take all the features in your pocket with our mobile app</p>
                    <span class = "download-span"><a href="#"></a></span>
                </div>
                <img src={Image} className="head-img" alt="head-img" width="35%" ></img>
            </div>
        </div>
    )
}
export default Download;
