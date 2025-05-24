import React, { Fragment } from "react";
import { useState,useEffect } from "react";
import axios from "axios"; // to  use useState


function Products(){

    // questi sono HOOKS!!
    // sono complicati MA
    // praticamente ti permettono di utilizzare delle funzionalità/classi di REACT
    // SENZA dover creare una classe stessa
    const [products, setProducts] = useState([]);
    // con products assegnamo un valore iniziale
    // se lo volessimo cambiare, NON VA fatto direttamente -> products = 'red';
    // ma ATTRAVERSO IL SET -> setProduct('red');


    /* MAP */
    // CREA un ARRAY da qualcosa
    // products.map((product) =>

    /* TO RETRIEVE DATA FROM THE BACKEND: AXIOS */

    useEffect(() => {
        const fetchData = async () => {
          
           const response = await axios.get("http://localhost:8080/products");
           setProducts(response.data);
          // console.log(response.data);
        
        };
    
        fetchData();
      }, []);

    return (
        <Fragment>
            <h3>showing products....</h3>
                <div className="grid">
                
                {products.map((product) => (
                    <div className="products-box">
                        <h2>{product.name}</h2>
                        <hr></hr>
                        <h2>{product.price} €</h2>
                        <h2>{product.id}</h2>
                        <a href="/add-product" className="button-to-add">Add product</a>
                    </div>
                ))
                }
                </div>
        </Fragment>
    )
}

export default Products