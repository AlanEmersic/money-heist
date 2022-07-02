import React, { useEffect, useState } from "react";
import { Paper, ThemeProvider } from "@mui/material";
import theme from "./utils/theme";
import axios from "axios";
import MemberList from "./components/member/MemberList";

function App() {
  const API = "http://localhost:8080/api";

  const [members, setMembers] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    getAllMembers();
  }, []);

  const getAllMembers = async () => {
    setLoading(true);
    let cancel: any = null;

    await axios
      .get(API + "/members", {
        cancelToken: new axios.CancelToken((ct) => {
          cancel = ct;
        }),
      })
      .then((res) => {        
        setMembers(res.data);
      })
      .then(() => {
        setLoading(false);
      })
      .catch((error) => {
        console.log(error);
      });

    return () => {
      cancel();
    };
  };

  return (
    <ThemeProvider theme={theme}>
      <Paper variant="outlined">
        <MemberList members={members} isloading={loading}/>
      </Paper>
    </ThemeProvider>
  );
}

export default App;
