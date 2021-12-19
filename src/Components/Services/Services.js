import React from "react";
import "./Services.css"
import Card from "./Card/Card";
import Image from "./ServicesAssets/Frame.svg"
import Image1 from "./ServicesAssets/element.svg";
import Image2 from "./ServicesAssets/Frame3.svg";
import Image3 from "./ServicesAssets/Frame4.svg";

const Services = () => {
    return (
        <div id = "Services" className="Services">
            <h1>Our Services</h1>
            <img src={Image1} alt="dots" className = "dotsSer" width="6%"></img>
            <div className="Cards">
            
            <Card className="Card" img = {Image} heading = "Tracking" content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam" />
            <Card img = {Image2} heading = "Online Pharmacy" content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam" />
            <Card img = {Image3} heading = "Searching" content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam" />
            </div>
        </div>
    )
}
export default Services;