import React, {useEffect, useState} from 'react'
import {NavLink} from "react-router-dom";
import axios from "axios";

export const UserEdit = (props) => {

    const initial = {
        userName: '',
        firstName: '',
        secondName: '',
        likedArtists: [],
        likedAlbums: [],
        likedTracks: []
    }

    useEffect(() => {
        axios.get(`http://localhost:8080/user/${props.match.params.id}`)
            .then(res => setUser(prevState => {
                return {
                    ...prevState,
                    userName: res.data.userName,
                    firstName: res.data.firstName,
                    secondName: res.data.secondName,
                    likedArtists: res.data.likedArtists,
                    likedAlbums: res.data.likedAlbums,
                    likedTracks: res.data.likedTracks,


                }
            }))
    }, [])

    const [user, setUser] = useState(initial)

    const onChangeHandler = (e) => {
        setUser(prevState => {
            return {...prevState, [e.target.name]: e.target.value}
        })
    }

    const {userName, secondName, firstName} = user

    const onCl = (e) => {
        e.preventDefault()

        const newUser = {
            userName,
            firstName,
            secondName
        }

        //console.log(newUser)
        axios.put(`http://localhost:8080/user/${props.match.params.id}`, newUser).then(res => console.log(res.data))
        props.history.push('/users')
    }

    const onClDel = (e) => {
        e.preventDefault()
        axios.delete(`http://localhost:8080/user/${props.match.params.id}`).then(res => console.log(res.data))
        props.history.push('/users')
    }

    //console.log(user.likedAlbums)

    return (
        <div>
            <div>
                <h1>User Edit!</h1>
                <form>
                    <div>
                        <input hidden="hidden"/>
                        <div>
                            <label for="userName">
                                Username:
                            </label>
                            <p><input onChange={onChangeHandler} value={user.userName}
                                      class="form-control-sm align-items-center" id="userName" name="userName"
                                      type="text"/></p>
                        </div>
                        <div>
                            <label for="firstName">
                                First Name:
                            </label>
                            <p><input onChange={onChangeHandler} value={user.firstName} class="form-control-sm"
                                      id="firstName" name="firstName" type="text"/>
                            </p>
                        </div>
                        <div>
                            <label for="secondName">
                                Second Name:
                            </label>
                            <p><input onChange={onChangeHandler} value={user.secondName} class="form-control-sm"
                                      id="secondName" name="secondName" type="text"/>
                            </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 col-md-1">
                            <button onClick={onCl} class="btn btn-dark" type="submit">
                                Update
                            </button>
                        </div>
                    </div>
                </form>
                <p></p>
                <div class="col-12 col-md-1">
                    <form>
                        <button onClick={onClDel} class="btn btn-dark" type="submit">
                            Delete
                        </button>
                    </form>
                </div>
            </div>

            <div class="container">
                <h3>Liked Artists</h3>
                <table class="table">
                    <thead class="thead-dark">
                    <tr>
                        <th>Artist's Name</th>
                        <th>Description</th>
                    </tr>
                    </thead>
                    <tbody>
                    {user.likedArtists.map((lArtist) => (
                        <tr>
                            <td>
                                {lArtist.name}
                            </td>
                            <td>
                                {lArtist.description}
                            </td>
                        </tr>
                    ))
                    }
                    </tbody>
                </table>
            </div>
            <div class="container">
                <h3>Liked Albums</h3>
                <table class="table">
                    <thead class="thead-dark">
                    <tr>
                        <th>Album's Name</th>
                        <th>Description</th>
                        <th>Release Date</th>
                    </tr>
                    </thead>
                    <tbody>
                    {user.likedAlbums.map((lArtist) => (
                        <tr>
                            <td>
                                {lArtist.name}
                            </td>
                            <td>
                                {lArtist.description}
                            </td>
                            <td>
                                {lArtist.releaseDate}
                            </td>
                        </tr>
                    ))
                    }
                    </tbody>
                </table>
            </div>
            <div class="container">
                <h3>Liked Tracks</h3>
                <table class="table">
                    <thead class="thead-dark">
                    <tr>
                        <th>Artist</th>
                        <th>Album</th>
                        <th>Name</th>
                    </tr>
                    </thead>
                    <tbody>
                    {user.likedTracks.map((lArtist) => (
                        <tr>

                            <td>
                                {lArtist.album.artist.name}
                            </td>
                            <td>
                                {lArtist.album.name}
                            </td>
                            <td>
                                {lArtist.name}
                            </td>
                        </tr>
                    ))
                    }
                    </tbody>
                </table>
            </div>
        </div>
    )
}