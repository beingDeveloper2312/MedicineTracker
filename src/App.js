import './App.css';
import Heading from './Components/Heading/Heading';
import React from 'react';
import Services from './Components/Services/Services';
import Footer from './Components/Footer/Footer';
import Download from './Components/Download/Download';
import Testimonial from './Components/Testimonial/Testimonial';
import TopNav from './Components/TopNav/TopNav'

import { HeadMob } from './Components/Heading-mob/HeadMob';
function App() {
    return (
        <div className="App">
            <div className='web'>
            <TopNav />
            <Heading />
            <br />
            <Services />
            <br />
            <Download />
            <Testimonial />
            <br />
            <Footer />
            </div>
            <div className='mob'>
               <HeadMob />
               <br />
               <Services />
               <br />
               <Testimonial />
            <br />
            <Footer />
            </div>
        </div>
    );
}

export default App;
