import React from "react";
import "./Card.css";

const Card = (props) => {
    return (
        <div className="Card">
        <div className="Card-Content">
            <img src = {props.img} alt = "card-img" width="20%"/>
            <br />
            <br />
            <h2>{props.heading}</h2>
            <p>{props.content}</p>
        </div>
        </div>
    )
}

export default Card;
