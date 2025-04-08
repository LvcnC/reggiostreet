import { useParams } from "react-router-dom";
import {  useEffect, useState } from "react";
import axios from "../axios";

const Product = () => {
  const { id } = useParams();
const [product, setProduct] = useState(null);

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
            <h1>{product.name}</h1>
            <h3>{product.description}</h3>
          </div>

          <div className="update-button ">
            <button
              className="btn btn-primary"
              type="button">
              Update
            </button>
        
            <button
              className="btn btn-primary"
              type="button"
            >
              Delete
            </button>
          </div>
    </>
  )
};

export default Product;