import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import Skeleton from "@mui/material/Skeleton";
import { Paper, Stack } from "@mui/material";

export default function Member({ member, isloading }: any) {
  const { name, email, skills, mainSkill, sex, status, id } = member;

  return isloading ? (
    <Skeleton variant="rectangular" height={150} sx={{ maxHeight: 300 }} />
  ) : (
    <Card sx={{ maxWidth: 300 }}>
      <CardMedia
        component="img"
        height="150"        
        src="/assets/img/member-icon.png"
        alt="member"
      />
      <CardContent>
        <Typography
          gutterBottom
          variant="h5"
          component="div"
          color={"darkgray"}
        >
          Id: #{id}
        </Typography>
        <Typography
          gutterBottom
          variant="h5"
          component="div"
          color={"darkcyan"}
        >
          Name: {name}
        </Typography>
        <Typography
          gutterBottom
          variant="body1"
          component="div"
          color={"darkkhaki"}
        >
          Email: {email}
        </Typography>
        <Typography
          gutterBottom
          variant="body1"
          component="div"
          color={"darkgoldenrod"}
        >
          Sex: {sex}
        </Typography>
        <Typography
          gutterBottom
          variant="h6"
          component="div"
          color={"darkturquoise"}
        >
          Main skill: {mainSkill.name}
        </Typography>
        <Typography
          gutterBottom
          variant="h6"
          component="div"
          sx={{ color: "#579ADE" }}
        >
          Skills
        </Typography>
        <Stack direction="row" spacing={2} sx={{ marginBottom : "2rem" }}>
          {skills.map((s: any) => {
            return (
              <Paper key={s.id} variant="elevation" sx={{ padding: 2 }}>
                <Typography
                  gutterBottom
                  variant="body2"
                  component="div"
                  color={"cyan"}
                >
                  Skill: {s.name}
                </Typography>
                <Typography
                  gutterBottom
                  variant="body2"
                  component="div"
                  color={"cyan"}
                >
                  Level: {s.level}
                </Typography>
              </Paper>
            );
          })}
        </Stack>
        <Typography variant="body2" color="darkseagreen">
          Status: {status}
        </Typography>
      </CardContent>
    </Card>
  );
}
