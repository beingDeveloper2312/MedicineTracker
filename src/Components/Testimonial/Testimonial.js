import React, { Component } from "react";
import "react-responsive-carousel/lib/styles/carousel.min.css";
import { Carousel } from "react-responsive-carousel";
import "./Testimonial.css"
import TestimonialCard from "./TestimonialCard";
import rv from "./TestimonialAssets/rv.jpeg";
import rj from "./TestimonialAssets/rj.jpeg";
import ss from "./TestimonialAssets/ss.jpeg";
import kt from "./TestimonialAssets/kt.jpeg";
export default class Testimonials extends Component {
  render() {
    return (
        <div className="Testi" id ="Testimonial">
        <h1>Contributors</h1>
      <Carousel
        showArrows={true}
        infiniteLoop={true}
        showThumbs={true}
        showStatus={false}
        autoPlay={true}
        interval={2000}
      >
        <TestimonialCard name = "Rohit Jaiswal" desg ="Web Team" Image = {rj} lin = "https://www.linkedin.com/in/rohit-jaiswal-557b871aa/" twit = "https://twitter.com/RohitJa01763744" />
        <TestimonialCard name = "Kunga Tashi" desg ="Web Team" Image = {kt} lin = "https://www.linkedin.com/in/kunga-tashi/" twit = "https://twitter.com/KuntashTweets"/>
        <TestimonialCard name = "Raunit Verma" desg ="App Team" Image = {rv} lin = "https://www.linkedin.com/in/iraunit/" twit = "https://twitter.com/iraunit" />
        <TestimonialCard name = "Shubhanshu Shubham" desg ="App Team" Image = {ss} lin = "https://www.linkedin.com/in/shubhanshu-shubham-13197714b/" twit = "https://twitter.com/DevWidShub" />
      </Carousel>
      </div>
    );
  }
}

