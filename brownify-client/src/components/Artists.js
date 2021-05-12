import React, {useEffect, useState} from 'react'
import {NavLink} from "react-router-dom";
import axios from "axios";

export const Artists = () => {

    const init = {
        name: '',
        description: ''
    }

    const [artistData, setArtistsData] = useState([])
    //const [artist, setArtist] = useState(init)
    const [users, setUsers] = useState([])
    const [id, setId] = useState('')

    useEffect(() => {
        axios('http://localhost:8080/artists').then(res => setArtistsData(res.data))
    }, [artistData])

    useEffect(() => {
        axios('http://localhost:8080/users').then(res => setUsers(res.data))
    }, [])


    const selectOnChange = (e) => {
        setId(e.target.value)
    }

    const handleSubmit = (e) => {
        e.preventDefault()
        console.log(id)

    }
    return (
        <div>
            <h1>Artists!</h1>
            <div className='button-user'>
                <NavLink to={'/addArtist'} className='btn btn-dark'>+</NavLink>
            </div>
            <table className="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                {artistData.map((artist, artist_id) => (
                    <tr key={artist_id}>
                        <td scope="row">{artist_id + 1}</td>
                        <td><NavLink to={`/artists/edit/${artist.id}`}>{artist.name}</NavLink></td>
                        <td>{artist.description}</td>
                        <td>
                            <form onSubmit={handleSubmit} className="form-inline">
                                <input hidden="hidden" name="artistId"/>
                                <select onChange={selectOnChange} className="form-select-sm" name="username">
                                    {users.map(user => (
                                        <option value={user.id}>{user.userName}</option>
                                    ))
                                    }
                                </select>
                                <button onClick={(e) => {
                                    axios.put(`http://localhost:8080/user/${id}/artist/${artist.id}`).then(res => console.log(res.data))
                                }} className="btn btn-dark" type="submit">Like
                                </button>
                            </form>
                        </td>
                    </tr>
                ))
                }
                </tbody>
            </table>
            <br/>
        </div>
    )
}