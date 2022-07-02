import React from "react";
import { Container, Grid } from "@mui/material";
import Member from "./Member";

export default function MemberList({ members, isloading }: any) {
  return (
    <Container>
      <Grid container spacing={5} mb={15}>
        {members &&
          members.map((m: any, index: number) => {
            return (
              <Grid item xs={12} sm={6} md={6} key={index}>
                <Member member={m} isloading={isloading} />
              </Grid>
            );
          })}
      </Grid>
    </Container>
  );
}
