import React from "react";
import { Helmet } from "react-helmet";
import "./footer.css";
import { Link } from 'react-router-dom';
const Footer = () => {
  let newDate = new Date();
  let year = newDate.getFullYear();
  return (
    <div>
      <footer className="footer">
        <ul className="social-icon">
          <li className="social-icon__item">
            <a className="social-icon__link" href="https://www.facebook.com/Medicare-Offical-Page-101771149045313/">
              <ion-icon name="logo-facebook"></ion-icon>
            </a>
          </li>
          <li className="social-icon__item">
            <a className="social-icon__link" href="/">
              <ion-icon name="logo-twitter"></ion-icon>
            </a>
          </li>
          <li className="social-icon__item">
            <a
              className="social-icon__link"
              href="https://www.linkedin.com/company/hack-club-nitrr/about/"
            >
              <ion-icon name="logo-linkedin"></ion-icon>
            </a>
          </li>
          <li className="social-icon__item">
            <a
              className="social-icon__link"
              href="https://www.instagram.com/invites/contact/?i=15hyqsjne4d3s&utm_content=nf6cwkb"
            >
              <ion-icon name="logo-instagram"></ion-icon>
            </a>
          </li>
        </ul>
        <ul className="menu-mob">
          <li className="menu__item">
            <a className="menu__link" href="#head">
              Home
            </a>
          </li>
          <li className="menu__item">
            <a className="menu__link" href="#Services">
              Services
            </a>
          </li>
          <li className="menu__item">
            <a className="menu__link" href="#Download">
              App
            </a>
          </li>
          <li className="menu__item">
          <Link to="login" className="menu__link">
                   Dashboard
                </Link>
          </li>
        </ul>
        <ul className="menu-web">
          <li className="menu__item">
            <a className="menu__link" href="#navBar">
              Home
            </a>
          </li>
          <li className="menu__item">
            <a className="menu__link" href="#Services">
              Services
            </a>
          </li>
          <li className="menu__item">
            <a className="menu__link" href="#Download-web">
              App
            </a>
          </li>
          <li className="menu__item">
          <Link to="login" className="menu__link">
                    Dashboard
          </Link>
          </li>
        </ul>

        <p>&copy; {year} MediCare</p>
      </footer>
      <Helmet>
        <script
          type="module"
          src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"
        ></script>
        <script
          nomodule
          src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"
        ></script>
      </Helmet>
    </div>
  );
};

export default Footer;
