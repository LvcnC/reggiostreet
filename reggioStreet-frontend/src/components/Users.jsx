import React, { Fragment } from "react";
import { useState } from "react"; 
import axios from "axios"; // to  use useState

function Users(){

    // ([]) -> we say it's going be an array?
    const [users, setUsers ] = useState([]);

        // 1. we ask AXIOS to get to the ENDPOINT of an API
        //    so we go to the digital place where the data is in the backend 
        axios.get("http://localhost:8080/users")
            .then(response =>{
                // 2. THEN -> if the response of the API actually arrives !
                //    we create a parameter(response in this case) and we decide to behave accordingly
                //     and do what we like with the data
                console.log(response) // we print what we got successfully from the backend

                // we put the response data (so the single USER) into the hook / array(?)
                setUsers(response.data);
            }
            ).catch(error => {
            // 2.5 CATCH -> or there could be an error from the responde of the API :(
                console.log(error)
            }
        )        

    
    return (
        <>
            {users.map((user) => (
                <div>
                    <h2>
                        {user.username}
                    </h2>
                    <h2>
                        {user.dob}
                    </h2>
                </div>
                ))
            }
        </>
    )

}


// https://www.youtube.com/watch?v=bMRrSqWFKqM
export default Users