import Image from "./HeadingAssets/Frame 2.svg";
import Image1 from "./HeadingAssets/element.svg";
import { Link } from 'react-router-dom';

import "./Heading.css";
const Heading = () => {
    return (
        <div id ="head" className="head web-head">
            <img src={Image1} alt="dots" className = "dots" width="6%"></img>
            <div className="heading">
               
                <div className="head-content">
                    <h1 className="head">Never move out of your medicine routine with Medi Tracker</h1>
                    <p>Medi Tracker reminds you before your medicine time, dosage, so that you never miss on your medicine .</p>
                    <span><Link to="login" className="navbar_link">
                       
                    </Link></span>
                </div>
                <img src={Image} className="head-img" alt="head-img" width="35%" ></img>
            </div>
        </div>
    )
}
export default Heading;