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
      <div className="containers">
        <div className="right-column">
          <div className="product-description">
            <h1>{product.name}</h1>
            <h5>{product.category}</h5>
            <p>{product.price}</p>
          </div>

          <div className="update-button ">
            <button
              className="btn btn-primary"
              type="button">
              Update
            </button>
        
            <button
              className="btn btn-primary"
              type="button">
              Delete
            </button>
          </div>
        </div>
      </div>
    </>
  );
};

export default Product;