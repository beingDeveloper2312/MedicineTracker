import React from "react";
import "./Services.css"
import Card from "./Card/Card";
import Image from "./ServicesAssets/Frame.svg"
import Image1 from "./ServicesAssets/element.svg";
import Image2 from "./ServicesAssets/Frame6.png";
import Image3 from "./ServicesAssets/Frame3.svg";

const Services = () => {
    return (
        <div id = "Services" className="Services">
            <h1>Features</h1>
            <img src={Image1} alt="dots" className = "dotsSer" width="6%"></img>
            <div className="Cards">
            
            <Card className="Card" img = {Image} heading = "Tracking" content = "Medi Tracker keeps track of your medicine timings, dosage and hence make sure that you never fall out of your medicine routine" />
            <Card img = {Image2} heading = "Never loose ur data" content = "We have online clould storage, so that you never loose your data, we created a backup for you, so that you can easily access your medicine details from any device. Also you can access and edit your dashboard from any device be it PC or mobile or any device " />
            <Card img = {Image3} heading = "Online Pharmacy" content = "We have also linked a trustable online pharmacy, so that you don't need to go anywhere from Medi Tracker for any of your pharmaceutical needs" />
            </div>
        </div>
    )
}
export default Services;