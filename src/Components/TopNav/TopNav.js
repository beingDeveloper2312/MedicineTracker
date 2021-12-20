import './TopNav.css';
import { Link } from 'react-router-dom';
import Image from "./Images/logoM.jpeg";
const TopNav = () => {
    const navItems = [
        { title: 'Home', href: '#navBar' },
        { title: 'App', href: '#Download-web' },
        { title: 'Testimonials', href: '#Testimonial' },
        { title: 'Services', href: '#Services' },
    ];
    return (
        <div id = "navBar" className="navbar">
            <div ><img className="navbar__logo" src = {Image} width = "20%"></img></div>
            <div className="navbar__link--container">
                {navItems.map((item, i) => (
                    <div key={i} className="navbar__item">
                        <a className="navbar__link" href={item.href}>
                            {item.title}
                        </a>
                    </div>
                ))}
                <Link to="login" className="navbar__link">
                    Register / Login
                </Link>
            </div>
            <a href="javascript:void(0);" class="icon" onclick="myFunction()">
                   <i class="fa fa-bars"></i>
            </a>
        </div>
    );
};

export default TopNav;
