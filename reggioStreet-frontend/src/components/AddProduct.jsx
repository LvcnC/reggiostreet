import React, { Fragment } from "react";
import { useState,useEffect } from "react";
import axios from "axios"; // to  use useState

const AddProduct = () => {

    const [product, setProduct] = useState({
        name: "",
        brand: "",
        description: "",
        price: "",
        category: "",
        stockQuantity: "",
        releaseDate: "",
        productAvailable: false,
    });


    useEffect(() => {
        const submitHandler  = async () => {
          try {
            const response = await axios.post(`http://localhost:8080/products`);
            setProduct(response.data);
            // console.log(response.data);
          } catch (error) {
            console.error("Error fetching product:", error);
          }
        };
    
        submitHandler();
      });
    

}
  export default AddProduct;