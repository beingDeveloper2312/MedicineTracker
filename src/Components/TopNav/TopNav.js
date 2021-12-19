import './TopNav.css';
const TopNav = () => {
    const navItems = [
        { title: 'Home', href: '#head' },
        { title: 'Services', href: '#Services' },
        { title: 'Apps', href: '#Download' },
        { title: 'Testimonials', href: '#Testimonials' },
        { title: 'About us', href: '#' },
    ];
    return (
        <div className="navbar">
            <div className="navbar__logo">M</div>
            <div className="navbar__link--container">
                {navItems.map((item, i) => (
                    <div key={i} className="navbar__item">
                        <a className="navbar__link" href={item.href}>
                            {item.title}
                        </a>
                    </div>
                ))}
            </div>
            <a href="javascript:void(0);" class="icon" onclick="myFunction()">
                   <i class="fa fa-bars"></i>
            </a>
        </div>
    );
};

export default TopNav;
