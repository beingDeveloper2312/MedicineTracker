import React from "react";
import "./Testimonial.css";

const TestimonialCard = (props) => {
    return (
        <div className="te-card">
          
          <div className="myCarousel">
           <img src={props.Image} width = "20%"/>
            <h3>{props.name}</h3>
            <h4>{props.desg}</h4>
            <br />
            <p>
              <a href = {props.lin} className="si">
              <ion-icon className = "social-icon__link" name="logo-linkedin"></ion-icon>
                </a>
              <a className="si" href = {props.twit}>
              <ion-icon name="logo-twitter"></ion-icon>
                </a>
            </p>
          </div>
        </div>
    )
}

export default TestimonialCard
