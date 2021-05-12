import React, {useEffect, useState} from 'react'
import {NavLink} from "react-router-dom";
import axios from "axios";

export const AddUser = (props) => {

    useEffect(() => {
        //axios('')
    }, [])

    const initial = {
        userName: '',
        firstName: '',
        lastName: ''
    }

    const [user, setUser] = useState(initial)

    const onChangeHandler = (e) => {
        setUser(prevState => {
            return {...prevState, [e.target.name]: e.target.value}
        })
    }

    const {userName, lastName, firstName} = user

    const onSub = (e) => {
        e.preventDefault()

        const newUser = {
            firstName,
            secondName: lastName,
            userName
        }
        axios.post('http://localhost:8080/users', newUser).then(res => console.log(res.data))
        props.history.push('/users')
    }
    return (
        <div>
            <h1>AddUser!</h1>
            <form onSubmit={onSub}>
                <div className="form-group">
                    <label htmlFor="fundNameInput">Username</label>
                </div>
                <input value={user.userName} onChange={onChangeHandler} name='userName' aria-describedby="emailHelp"
                       className="form-control" id="fundNameInput"
                       type="text"/>
                <div className="form-group">
                    <label htmlFor="setNameInput">First name</label>
                    <input value={user.firstName} onChange={onChangeHandler} name='firstName' type="text"
                           className="form-control" id="setNameInput"/>
                </div>
                <div className="form-group">
                    <label htmlFor="itemNameInput">Second name</label>
                    <input value={user.lastName} onChange={onChangeHandler} name='lastName' type="text"
                           className="form-control" id="itemNameInput"/>
                </div>
                <p></p>
                <button type="submit" className="btn btn-dark">Submit</button>
            </form>
        </div>
    )
}