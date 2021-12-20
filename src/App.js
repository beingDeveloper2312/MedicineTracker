import './App.css';
import Heading from './Components/Heading/Heading';
import React from 'react';
import Services from './Components/Services/Services';
import Footer from './Components/Footer/Footer';
import Download from './Components/Download/Download';
import Testimonial from './Components/Testimonial/Testimonial';
// import TopNav from './Components/TopNav/TopNav'

import { HeadMob } from './Components/Heading-mob/HeadMob';
import { DownMob } from './Components/Download-mob/DownMob';
import NavBar from './Components/NavBar2/NavBar';

function App() {
    return (
        <div className="App">
            <NavBar />
            <div className='mob'>
                <HeadMob />
            </div>

            <div className='web'>
            <Heading />
            </div>
            <br />
            <Services />
            <br />
            <div className='mob'>
                <DownMob />
                <br />
                <br />
            </div>
            <div className='web'>
               <Download />
            </div>
            <Testimonial />
            <Footer />
            
        </div>
    );
}

export default App;
