import React, {useEffect, useState} from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container,Paper,Button } from '@mui/material';


export default function Student() {
    const paperStyle={padding:'50px 20px', width:600, margin:"20px auto"}
    const [name,setName] = useState('')
    const [id,setId] = useState('')
    const [students,setStudents] = useState([])

    const handleClick = (e) => {
        e.preventDefault()
        const student = {id,name}
        console.log(student)
        fetch("http://localhost:8080/student/add",{
            method:"POST",
            headers: {"Content-Type":"application/json"},
            body: JSON.stringify(student)
        }).then(()=>{
            console.log("new student added")
        })
    }
    useEffect(()=>{
        fetch("http://localhost:8080/student/getAll")
        .then(res=>res.json())
        .then((result)=>{
            setStudents(result);
        }
        )
    },[])
    
    return (
        <Container>
            <Paper elevation={3} style={paperStyle}>

                <h1 style={{color:"blue"}}><u>Add Student</u></h1>
                <Box
                component="form"
                sx={{
                    '& > :not(style)': { m: 1 },
                }}
                noValidate
                autoComplete="off"
                >
                <TextField id="outlined-basic" label="Student ID" variant="outlined" fullWidth
                value = {id}
                onChange={(e)=>setId(e.target.value)}
                />
                <TextField id="outlined-basic" label="Student Name" variant="outlined" fullWidth
                value = {name}
                onChange={(e)=> setName(e.target.value)}
                />

                <Button variant="contained" onClick={handleClick}>
                    Submit
                </Button>

                </Box>
            </Paper>

            <h1> Students </h1>
            <Paper elevation={3} style={paperStyle}>
                {students.map(student =>(
                    <Paper elevation={6} stle = {{margin:"10px", padding:"15px", textAlign:"center"}} key={student.id}>
                        Id: {student.id}<br/>
                        Name: {student.name} 
                    </Paper>
                    ))
                }
            </Paper>
        </Container>
    );
}
