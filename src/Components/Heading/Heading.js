import Image from "./HeadingAssets/Frame 2.svg";
import Image1 from "./HeadingAssets/element.svg";
import "./Heading.css";
const Heading = () => {
    return (
        <div>
            
            <div className="heading">
               <img src={Image1} alt="dots" className = "dots" width="7%"></img>
                <div className="head-content">
                    <h1 className="head">Never forget to take Medicine</h1>
                    <p>Trafalgar provides progressive, and affordable healthcare, accessible on mobile and online for everyone</p>
                    <span><a href="#"></a></span>
                </div>
                <img src={Image} className="head-img" alt="head-img" width="35%" ></img>
            </div>
        </div>
    )
}
export default Heading;