import React, {useState} from 'react'
import {NavLink} from "react-router-dom";
import axios from "axios";

export const AddArtist = (props) => {

    const init = {
        name: '',
        description: ''
    }

    const onSub = (e) => {
        e.preventDefault()

        const obj = {
            name: artist.name,
            description: artist.description
        }

        axios.post(`http://localhost:8080/artists`, obj).then(res => res.data)
        setArtist(prevState => {
            return {...prevState, name: '', description: ''}
        })
        props.history.push('/artists')
    }

    const onChangeHandler = (e) => {
        setArtist(prevState => {
            return {...prevState, [e.target.name]: e.target.value}
        })
    }

    const [artist, setArtist] = useState(init)
    return (
        <div>
            <h1>Add artist!</h1>
            <br/>
            <form onSubmit={onSub}>
                <p>
                    <input value={artist.name} onChange={onChangeHandler} className="form-control-sm" name="name"
                           placeholder="name" type="text"/>
                </p>
                <p>
                    <textarea value={artist.description} onChange={onChangeHandler} className="form-control-sm"
                              name="description" placeholder="description"
                              rows="3"/>
                </p>
                <p>
                    <button className="btn btn-dark" type="submit">new.</button>
                </p>
            </form>
        </div>
    )
}