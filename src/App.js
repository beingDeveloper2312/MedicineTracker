import './App.css';
import Heading from './Components/Heading/Heading';
import TopNav from './Components/TopNav/TopNav';
import Services from './Components/Services/Services';
import Footer from './Components/Footer/Footer';
import Download from './Components/Download/Download';
import Testimonial from './Components/Testimonial/Testimonial';
function App() {
    return (
        <div className="App">
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
    );
}

export default App;
