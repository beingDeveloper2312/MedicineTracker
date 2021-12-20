import Image from "./HeadingAssets/Frame 2.svg";
import Image1 from "./HeadingAssets/element.svg";
import { Link } from 'react-router-dom';

import "./Heading.css";
const Heading = () => {
    return (
        <div className = "head">
        <div id ="head" className="head web-head">
            <img src={Image1} alt="dots" className = "dots" width="6%"></img>
            <div className="heading">
               
                <div className="head-content">
                    <h1 className="head">Never forget to take Medicine</h1>
                    <p>Medicare reminds you before your meficine time, keeps track of your stOck and dosage, so that you never miss on your medicine</p>
                    <br />
                    <span><Link to="login" className="navbar__link">
                    Register / Login
                    </Link></span>
                </div>
                <img src={Image} className="head-img" alt="head-img" width="30%" ></img>
            </div>
        </div>
        </div>
    )
}
export default Heading;