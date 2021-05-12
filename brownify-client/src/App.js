import React from 'react';
import './App.css';
import {Header} from "./components/Header";
import {Route} from "react-router-dom";
import {Users} from "./components/Users";
import {Artists} from "./components/Artists";
import {Albums} from "./components/Albums";
import {Tracks} from "./components/Tracks";
import {AddUser} from "./components/AddUser";
import {UserEdit} from "./components/UserEdit";
import {ArtistEdit} from "./components/ArtistEdit";
import {AddArtist} from "./components/AddArtist";

const App = () => {
    return (
        <div className="container">
            <Header/>
            <Route exact path={'/'} render={()=> <h1>Main</h1>}/>
            <Route exact path={'/users'} component={Users}/>
            <Route exact path={'/artists'} component={Artists}/>
            <Route path={'/albums'} component={Albums}/>
            <Route path={'/tracks'} component={Tracks}/>
            <Route path={'/addUser'} component={AddUser}/>
            <Route path={'/addArtist'} component={AddArtist}/>
            <Route path={'/users/edit/:id'} component={UserEdit}/>
            <Route path={'/artists/edit/:id'} component={ArtistEdit}/>
        </div>
    );
}

export default App;
