import React from "react";
import "./Navbar.css";
import Image from "./Images/logoM.jpeg"
const Navbar = () => {
    return (
        <div>
            <img src = {Image} className="logo"></img>
            <div className="mid">
            <a href = "#">Home</a>
            <a href = "#">Home</a>
            <a href = "#">Home</a>
            <a href = "#">Home</a>
            </div>
        </div>
    )
}

export default Navbar
