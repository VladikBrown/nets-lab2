import React from 'react'
import {NavLink} from "react-router-dom";

export const Header = () => {
    return (
        <div>
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <div className="container-fluid">
                    <NavLink to='/users' className="navbar-brand" >Brownify!</NavLink>
                    <div className="collapse navbar-collapse" id="navbarNav">
                        <ul className="navbar-nav">
                            <li className="nav-item">
                                <NavLink className="nav-link active" aria-current="page" to="/users">Users</NavLink>
                            </li>
                            <li className="nav-item">
                                <NavLink className="nav-link" to="/artists">Artists</NavLink>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    )
}