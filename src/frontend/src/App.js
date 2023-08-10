import './App.css';
import {getAllStudents} from "./client";
import {useState, useEffect} from "react";

function App() {
    const [students, setStudents] = useState([]);

    const fetchStudents = () => {
        return getAllStudents()
            .then(res => res.json())
            .then(data => {
                console.log(data);
                setStudents(data);
            })
    }

    useEffect(() => {
        console.log("component is mounted");
        fetchStudents();
    }, []);

    if (students.length <= 0) {
        return "No data";
    }

    return students.map((student, index) => {
        return <p key={index}>{student.id} {student.name}</p>;
    });
}

export default App;
