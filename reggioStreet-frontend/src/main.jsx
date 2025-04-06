import { Fragment, StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'

// TO RUN the app:
//    ->  npm run dev

// TO CREATE the APP:
//    ->  npx create-react-app {app}
//    -> cd {app}
createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
  </StrictMode>
)

// Fragment or <> wraps around multiple tags, so you dont have to
// fill the html with useless main tags
function MainContent(){

  return (
      <Fragment>
          <Header />
          <h1>Reasons Why I Like React </h1>
          <ul>
              <li>Reason one</li>
              <li>Reason three</li>
          </ul>
      </Fragment>
  )
}
