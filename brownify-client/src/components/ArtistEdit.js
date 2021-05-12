import React, {useEffect, useState} from 'react'
import {NavLink} from "react-router-dom";
import axios from "axios";

export const ArtistEdit = (props) => {

    const initial = {
        name: '',
        description: '',
        albums: []
    }

    const albums = {
        name: '',
        releaseDate: '',
        description: ''
    }

    useEffect(() => {
        axios.get(`http://localhost:8080/artist/${props.match.params.id}`)
            .then(res => setArtist(prevState => {
                return {
                    ...prevState,
                    name: res.data.name,
                    description: res.data.description,
                    albums: res.data.albums
                }
            }))
    }, [])

    useEffect(() => {
        axios('http://localhost:8080/users').then(res => setUsers(res.data))
    }, [])

    const [artist, setArtist] = useState(initial)
    const [album, setAlbum] = useState(albums)
    const [users, setUsers] = useState([])
    const [id, setId] = useState('')

    const onChangeHandler = (e) => {
        setArtist(prevState => {
            return {...prevState, [e.target.name]: e.target.value}
        })
    }

    const onChangeHandlerSec = (e) => {
        setAlbum(prevState => {
            return {...prevState, [e.target.name]: e.target.value}
        })
    }

    const {name, description} = artist

    const onCl = (e) => {
        e.preventDefault()

        const newArtist = {
            name,
            description,
        }

        axios.put(`http://localhost:8080/artist/${props.match.params.id}`, newArtist).then(res => console.log(res.data))
        props.history.push('/artists')
    }

    const onClDel = (e) => {
        e.preventDefault()
        axios.delete(`http://localhost:8080/artist/${props.match.params.id}`).then(res => console.log(res.data))
        props.history.push('/artists')
    }

    const selectOnChange = (e) => {
        setId(e.target.value)
    }

    const handleSubmit = (e) => {
        e.preventDefault()
        console.log(id)

    }

    const albumSubmit = (e) => {
        e.preventDefault()
        let obj = {
            name: album.name,
            releaseDate: album.releaseDate,
            description: album.description
        }
        axios.post(`http://localhost:8080/artist/${props.match.params.id}/album`, obj).then(res=>console.log(res.data))

    }

    return (
        <div>
            <h1>ArtistEdit!</h1>

            <div className="container rounded">
                <div className="container">
                    <form>
                        <div>
                            <div>
                                <label htmlFor="artistName">
                                    Name:
                                </label>
                                <p><input onChange={onChangeHandler} value={artist.name}
                                          className="form-control-sm align-items-center"
                                          id="artistName" name="name"
                                          type="text"/>
                                </p>
                            </div>
                            <div>
                                <label htmlFor="description">
                                    Description:
                                </label>
                                <p><input onChange={onChangeHandler} value={artist.description}
                                          className="form-control-sm" id="description"
                                          name="description"
                                          type="text"/>
                                </p>
                            </div>
                        </div>
                        <div className="row">
                            <div className="col-12 col-md-1">
                                <button onClick={onCl} className="btn btn-dark" type="submit">
                                    Update
                                </button>
                            </div>
                        </div>
                    </form>
                    <p></p>
                    <div className="col-12 col-md-1">
                        <form>
                            <button onClick={onClDel} className="btn btn-dark" type="submit">
                                Delete
                            </button>
                        </form>
                    </div>
                    <p></p>
                </div>

                <div className="container">
                    <h3>discography.</h3>
                    {artist.albums.map(album => (
                        <div>
                            <h2 style={{marginTop: 40}}>{album.name}</h2>
                            <form onSubmit={handleSubmit} className="form-inline" method="post">
                                <label className="col-form-label-lg" htmlFor="likeSelect">
                                </label>
                                <input hidden="hidden" name="albumId"/>
                                <select onChange={selectOnChange} className="form-select-sm" id="likeSelect"
                                        name="username">
                                    {users.map(user => (
                                        <option value={user.id}>{user.userName}</option>
                                    ))
                                    }
                                </select>
                                <button onClick={() => {
                                    axios.put(`http://localhost:8080/user/${id}/album/${album.id}`).then(res => console.log(res.data))
                                    setId('')
                                }} className="btn btn-dark" type="submit">Like
                                </button>
                            </form>
                            <p></p>

                            <table className="table">
                                <thead className="thead-dark">
                                <tr>
                                    <th>artist</th>
                                    <th>name</th>
                                    <th>album</th>
                                    <th>action</th>
                                </tr>
                                </thead>
                                <tbody>
                                {
                                    album.tracks.map(track => (
                                        <tr>
                                            <td>
                                                {album.artist.name}
                                            </td>
                                            <td>
                                                {track.name}
                                            </td>
                                            <td>
                                                {album.name}
                                            </td>
                                            <td>
                                                <form onSubmit={handleSubmit} className="form-inline">
                                                    <input hidden="hidden" name="trackId"/>
                                                    <select onChange={selectOnChange} className="form-select-sm"
                                                            name="username">
                                                        {users.map(user => (
                                                            <option value={user.id}>{user.userName}</option>
                                                        ))
                                                        }
                                                    </select>
                                                    <button onClick={() => {
                                                        //console.log(`http://localhost:8080/user/${id}/track/${track.id}`)
                                                        axios.put(`http://localhost:8080/user/${id}/track/${track.id}`).then(res => console.log(res.data))
                                                        //setId('')
                                                    }} className="btn btn-dark" type="submit">Like
                                                    </button>
                                                </form>
                                            </td>
                                        </tr>
                                    ))
                                }

                                </tbody>
                            </table>

                            <p></p>
                            <form className="form-inline" method="post">
                                <input className="form-control-sm" name="name" type="text"/>
                                <button className="btn btn-dark" type="submit">Add</button>
                            </form>
                        </div>
                    ))
                    }
                    <br/>
                    <br/>
                    <br/>
                    <div>
                        <p>
                            here you can add new album.
                        </p>
                        <form onSubmit={albumSubmit}>
                            <div>
                                <input onChange={onChangeHandlerSec} value={album.name} className="form-control-sm" name="name" placeholder="name"
                                       type="text"/>
                                <input onChange={onChangeHandlerSec} value={album.releaseDate} className="form-control-sm" name="releaseDate"
                                       placeholder="releaseDate"
                                       type="text"/>
                            </div>
                            <div>
                        <textarea onChange={onChangeHandlerSec} value={album.description} className="form-control-sm" name="description"
                                  placeholder="description"
                                  rows="3"></textarea>
                            </div>
                            <button className="btn btn-dark" type="submit">Add</button>
                            <br/>
                            <br/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}