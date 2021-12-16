import './TopNav.css';
const TopNav = () => {
    const navItems = [
        { title: 'Home', href: '#' },
        { title: 'Find a Doctor', href: '#' },
        { title: 'Apps', href: '#' },
        { title: 'Testimonials', href: '#' },
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
        </div>
    );
};

export default TopNav;
