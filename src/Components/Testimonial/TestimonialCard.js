import React from "react";
import "./Testimonial.css";
import Image from "./TestimonialAssets/Group 5.svg";
const TestimonialCard = () => {
    return (
        <div className="te-card">
          
          <div className="myCarousel">
           <img src={Image} width = "20%"/>
            <h3>Shirley Fultz</h3>
            <h4>Designer</h4>
            <p>
              It's freeing to be able to catch up on customized news and not be
              distracted by a social media element on the same site
            </p>
          </div>
        </div>
    )
}

export default TestimonialCard
