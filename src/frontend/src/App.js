import './App.css';
import {getAllStudents} from "./client";

function App() {

    getAllStudents()
        .then(res => res.json())
        .then(console.log)
    return "hellooooo";
}

export default App;
