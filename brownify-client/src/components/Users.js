import React, {useEffect, useState} from 'react'
import {NavLink} from "react-router-dom";
import axios from "axios";
import '../index.css'

export const Users = (props) => {

    const [userData, setUserData] = useState([])

    useEffect(() => {
        axios('http://localhost:8080/users').then(res => setUserData(res.data))
    }, [userData])

    return (
        <div>
            <div className='button-user'>
                <NavLink to={'/addUser'} className='btn btn-dark'>+</NavLink>
            </div>
            <table className="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Username</th>
                    <th scope="col">Firstname</th>
                    <th scope="col">Lastname</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                {userData.map((user,user_id) => (
                    <tr>
                        <th scope="row">{user_id+1}</th>
                        <td>{user.userName}</td>
                        <td>{user.firstName}</td>
                        <td>{user.secondName}</td>
                        <td><NavLink to={`users/edit/${user.id}`}>edit</NavLink></td>
                    </tr>
                ))
                }
                </tbody>
            </table>
        </div>
    )
}