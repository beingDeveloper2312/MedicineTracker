import React, { Component } from "react";
import "react-responsive-carousel/lib/styles/carousel.min.css";
import { Carousel } from "react-responsive-carousel";
import "./Testimonial.css"
import TestimonialCard from "./TestimonialCard";

export default class Testimonials extends Component {
  render() {
    return (
        <div className="Testi">
        <h1>Testimonials</h1>
      <Carousel
        showArrows={true}
        infiniteLoop={true}
        showThumbs={true}
        showStatus={false}
        autoPlay={true}
        interval={6100}
      >
        
        <TestimonialCard />
        <TestimonialCard />
        <TestimonialCard />

      </Carousel>
      </div>
    );
  }
}

