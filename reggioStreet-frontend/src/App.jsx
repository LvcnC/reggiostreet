import { useState } from 'react'
import './App.css'
import NavBar from './components/NavBar' // import the component you want
import Home from './components/Home'
import Products from './components/Products'
import { BrowserRouter, Routes, Route } from "react-router-dom"; // import the routes to use them!!
// THIS you MUST IMPORT
// 1. ADD -> " "react-router-dom": "^6.30.0" "        into the dependencies of package.json
// 2. RUN -> "  npm install --save react-router-dom"  into the TERMINALE

function App() {
  const [count, setCount] = useState(0)

  return (
    
      <BrowserRouter>
          <NavBar />
          <Routes>
            <Route path="/" element={<Home />}  />
            <Route path="/products" element={<Products />} />
          </Routes>
    </BrowserRouter>
    
  )
}
// ROUTES manage where URL that the user chooses
  // if it types '/products' -> <App /> should LOAD the COMPONENT 'Products', which will do it job
// in this case APP is the main PAGE which will load different componenent when asked TO
// for example, the NAVBAR stays because it's not depended on the route, but always stays in the APP

export default App
