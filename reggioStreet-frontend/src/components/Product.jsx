import { useParams } from "react-router-dom";
import {  useEffect, useState } from "react";
import axios from "axios";

const Product = () => {
  const { id } = useParams();
  const [product, setProduct] = useState([]);

  useEffect(() => {
    const fetchProduct = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/products/${id}`);
        setProduct(response.data);
        console.log(response.data);
      } catch (error) {
        console.error("Error fetching product:", error); 
      }
    };

    fetchProduct();
  }, [id]);

  return (
    <>
      <div className="product-box">

            <h1>{product.name}</h1>
            <hr></hr>
            <h3>Category: {product.category}</h3>
            <h3>Price: {product.price} euros</h3>
          </div>

          <div className="update-button">
            <button
              className="button-to-add"
              type="button">
              Update
            </button>
        
            <button
              className="button-to-delete"
              type="button">
              Delete
            </button>
          </div>
    </>
  );
};

export default Product;