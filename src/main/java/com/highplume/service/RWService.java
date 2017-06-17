package com.highplume.service;

import org.eclipse.persistence.config.CacheUsage;
import org.eclipse.persistence.config.QueryHints;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.*;
import java.net.URI;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.*;

//import java.util.*;
//import javax.mail.*;
//import javax.mail.internet.*;
//import javax.activation.*;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//@formatter:off

@Path("/")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Stateless
public class RWService {

  // ======================================
  // =             Attributes             =
  // ======================================

  @PersistenceContext(unitName = "chapter15PU")
  private EntityManager em;
  @Context
  private UriInfo uriInfo;

  String logFile = "highplumeRWService.log";
  String logTrigger = "highplumelog.trigger";

  // ======================================
  // =           Public Methods           =
  // ======================================


    /*------------------------*/
	
/*
-------Case insensitive index--------------

 CREATE INDEX idx_groups_name ON groups lower(name);

-----Stored Procedure-------
CREATE OR REPLACE FUNCTION get_avg(param_corpID text)
RETURNS real AS $$
DECLARE
cnt real;

BEGIN
create temporary table if not exists temp_gids (gid int not null) on commit drop;

insert into temp_gids (gid) SELECT count(RECEIVINGMEMBERID) AS NUMOFSTARSREC
FROM STARGIVEN
INNER JOIN MEMBER ON RECEIVINGMEMBERID = MEMBER.ID
WHERE MEMBER.CORPID = param_corpID
GROUP BY MEMBER.NAMEFIRST, MEMBER.NAMELAST, MEMBER.ID
ORDER BY NUMOFSTARSREC DESC;

select into cnt avg(gid) from temp_gids;

return cnt;

END; $$
LANGUAGE plpgsql;

------stored procedure------------

select get_avg('1');
------run stored procedure------------

getAllUsersByCorp
_usersByDept
getAllUsersByDept
getdDeptUserData
getAvgGiving
getGivers
getReceivers
msds
_receiverTotalsPerDept
_giverTotalsPerDept
IdUserNameValue
_getUserDecile
_getPercentRank
_giverValuesRanking
_ReceiverValuesRanking
getCorpvalues
getInfluence
_deptGiverTotals
_deptRecTotals
getDeptTotals
getStars
test
addQualities()
addQualities
initDB
getQualities
getQualitiesComposite
qualityProfile
quality
giveStar
addMember
changePwd
inactiveUser
changeUserDept
userInfo
loginMember
_deptByCorp
getDeptByCorp
GetCorpID
validateEmailP
validateEmail
sendMailTLS




members
users
usersbycorp/{corpID}
usersbydept/{corpID}/{departmentID}
deptuserdata/{corpID}
giver/{corpID}/{receiverID}
receivers/{corpID}/{giverID}
    _msds (double[] x, int n)
     _receiverTotalsPerDept(String corpID, String UserID)
     _giverTotalsPerDept(String corpID, String UserID)
     IdUserNameValue _getUserDecile(java.util.ArrayList<IdUserNameValue> userArray, String userID)

influence/{corpID}/{gr}/{wl}/{userID: .*}
influence/{corpID}/{wl}/{userID: .*}
    _deptGiverTotals(String corpID)
    _deptRecTotals(String corpID)
depttotals/{corpID}
getstars/{corpID}/{givingOrReceiving}
test
initdb
givestar/{givingMemberID}/{receivingMemberID}
addmember
changepwd
userinfo
login -POST
    _deptByCorp(String corpID)
getdeptbycorp
getcorpid
validateemailp
validateemail
sendmailtls
*/

    /*------------------------*/

    /*------------------------*/

    /*------------------------*/




/*    @GET
    @Path("test")
    @Produces("application/json")
    public String test() {
        String retStr;

        double avg = getAvgGiving("1").doubleValue();
        retStr = "getAvgGiving = " + Double.toString(avg);
        avg = getGeneralsAvg("1");
        retStr += "\n getGeneralAvg = " + Double.toString(avg);


    return retStr;*/



/*
IdUserNameValue test = new IdUserNameValue();

test.setId("1");


        IdUserNameValue[] Sorted = new IdUserNameValue[3];

            Sorted[0] = new IdUserNameValue();
            Sorted[0].setId("1");
            Sorted[0].setNameFirst("Henry");
            Sorted[0].setNameMiddle("David");
            Sorted[0].setNameLast("Thoreau");
            Sorted[0].setValue(1.1);

            Sorted[1] = new IdUserNameValue();
            Sorted[1].setId("2");
            Sorted[1].setNameFirst("Henry2");
            Sorted[1].setNameMiddle("David2");
            Sorted[1].setNameLast("Thoreau2");
            Sorted[1].setValue(1.2);

            Sorted[2] = new IdUserNameValue();
            Sorted[2].setId("3");
            Sorted[2].setNameFirst("Henry3");
            Sorted[2].setNameMiddle("David3");
            Sorted[2].setNameLast("Thoreau3");
            Sorted[2].setValue(0.2);

            Arrays.sort(Sorted);

            return Sorted[0].getNameFirst()+
                    Sorted[0].getValue()+

                    Sorted[1].getNameFirst()+
                    Sorted[1].getValue()+

                    Sorted[2].getNameFirst()+
                    Sorted[2].getValue();
*/

        /*
        //Add Departments and Corporations
        Corp corp = new Corp("Sierra Club", "http://www.sierraclub.org/");
        em.persist(corp);
        return ("corp="+corp.getName()+corp.getId()+corp.getWebsite());
*/





/*        return "{\"data\":  [" +
        "        {\"a\": \"1The Lord of the Rings\", \"b\": \"J. R. R. Tolkien\"}," +
        "        {\"a\": \"2Le Petit Prince (The Little Prince)\", \"b\": \"Antoine de Saint-Exupéry\"}," +
        "        {\"a\": \"3Harry Potter and the Philosopher's Stone\", \"b\": \"J. K. Rowling\"}," +
        "        {\"a\": \"4And Then There Were None\", \"b\": \"Agatha Christie\"}," +
        "        {\"a\": \"5Dream of the Red Chamber\", \"b\": \"Cao Xueqin\"}," +
        "        {\"a\": \"6The Hobbit\", \"b\": \"J. R. R. Tolkien\"}," +
        "        {\"a\": \"7She: A History of Adventure\", \"b\": \"H. Rider Haggard\"}" +
        "      ]}";
    }*/


    /*--------------------------*/
		
    public void log (String output){
		log(output, 0);
	}
		

    public void log (String output, int logLevel){
//        String path = ROService.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		File f1 = new File("."); 				// f is the current directory; where the JVM was launched  => C:\Users\Latitude Owner\Documents\payara41\glassfish\domains\domain1\config\.
		String path = f1.getAbsolutePath();
        String decodedPath = "";
        try{
            decodedPath = URLDecoder.decode(path, "UTF-8");
        }catch (UnsupportedEncodingException e){
             e.printStackTrace();
        } 

		decodedPath = decodedPath.substring(0, decodedPath.indexOf("config")) + "logs\\";
		
        File f = new File(decodedPath+logTrigger);				//if logTrigger file exists, log everything.  Otherwise only log level 0 stuff.
        if(f.exists() || logLevel == 0) {
            Calendar calendar = Calendar.getInstance();
            java.util.Date now = calendar.getTime();

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(decodedPath+logFile, true))) {
                bw.write(decodedPath+"---"+now.toString() + ":" + output);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*-------------------*/

    @GET
    @Path("addqualities/{corpID}/{userToken}")
    @Produces("application/json")
    public String addQualities(@PathParam("corpID") String corpID, @PathParam("userToken") String userToken) {

		if (!validUserAndLevel(corpID, userToken, null,"101"))
			return "ERROR: Unauthorized";
	
        java.util.ArrayList<String> tuTypeIdList = new java.util.ArrayList<>();
        addQualities(tuTypeIdList);

        return "SUCCESS";
    }
    /*-------------------*/

    public void addQualities (java.util.ArrayList<String> tuTypeIdList){


        //TUType
        TUType general = new TUType("General", "General Awesomeness");
        em.persist(general);
        tuTypeIdList.add(general.getId());

        TUType intelligence = new TUType("Intelligence", "Exhibits smarts and self-awareness");
        em.persist(intelligence);
        tuTypeIdList.add(intelligence.getId());

        TUType goodJudgement = new TUType("Judgement", "Wise decision maker");
        em.persist(goodJudgement);
        tuTypeIdList.add(goodJudgement.getId());

        TUType positivity = new TUType("Positivity", "Optimistic in attitude");
        em.persist(positivity);
        tuTypeIdList.add(positivity.getId());

        TUType urgency = new TUType("Bias for Action", "Tends to move quickly");
        em.persist(urgency);
        tuTypeIdList.add(urgency.getId());

        TUType openness = new TUType("Openness", "Naturally collaborative");
        em.persist(openness);
        tuTypeIdList.add(openness.getId());

        TUType integrity = new TUType("Integrity", "Honest, earnest and sincere");
        em.persist(integrity);
        tuTypeIdList.add(integrity.getId());

        TUType conscientiousness = new TUType("Conscientiousness", "Does what is right");
        em.persist(conscientiousness);
        tuTypeIdList.add(conscientiousness.getId());

        TUType EI = new TUType("Emotional Intel.", "High social perception");
        em.persist(EI);
        tuTypeIdList.add(EI.getId());

        TUType enthusiastic = new TUType("Enthusiasm", "Upbeat, eager and passionate");
        em.persist(enthusiastic);
        tuTypeIdList.add(enthusiastic.getId());

        TUType selfless = new TUType("Selflessness", "Team over self");
        em.persist(selfless);
        tuTypeIdList.add(selfless.getId());

        TUType empathetic = new TUType("Empathy", "Understands feelings of others");
        em.persist(empathetic);
        tuTypeIdList.add(empathetic.getId());

        TUType trustworthy = new TUType("Trustworthiness", "Faithful, honest and loyal");
        em.persist(trustworthy);
        tuTypeIdList.add(trustworthy.getId());

        TUType humility = new TUType("Humility", "Modest and humble");
        em.persist(humility);
        tuTypeIdList.add(humility.getId());

        TUType flexibility = new TUType("Flexibility", "Dynamic and adaptable");
        em.persist(flexibility);
        tuTypeIdList.add(flexibility.getId());

        TUType curiosity = new TUType("Curiosity", "Desire to learn");
        em.persist(curiosity);
        tuTypeIdList.add(curiosity.getId());

        TUType humor = new TUType("Humor", "Perceives and appreciates humor");
        em.persist(humor);
        tuTypeIdList.add(humor.getId());

        TUType innovation = new TUType("Innovation", "Introduces new methods and ideas");
        em.persist(innovation);
        tuTypeIdList.add(innovation.getId());

        TUType risktaking = new TUType("Risk-taking", "Confidence in taking smart risk");
        em.persist(risktaking);
        tuTypeIdList.add(risktaking.getId());

        TUType cautious = new TUType("Cautiousness", "Avoids potential problems");
        em.persist(cautious);
        tuTypeIdList.add(cautious.getId());

        TUType tenacity = new TUType("Tenacity", "Persistent and determined");
        em.persist(tenacity);
        tuTypeIdList.add(tenacity.getId());

        TUType purposeful = new TUType("Purposefulness", "Has clear intention or aim");
        em.persist(purposeful);
        tuTypeIdList.add(purposeful.getId());

        TUType openminded = new TUType("Open-mindedness", "Willing to consider new ideas");
        em.persist(openminded);
        tuTypeIdList.add(openminded.getId());

        TUType objectivity = new TUType("Objectivity", "Impartial decision-making");
        em.persist(objectivity);
        tuTypeIdList.add(objectivity.getId());

        TUType logic = new TUType("Logic", "Exhibits analytical reasoning");
        em.persist(logic);
        tuTypeIdList.add(logic.getId());

        TUType communication = new TUType("Communication", "Effective information sharing");
        em.persist(communication);
        tuTypeIdList.add(communication.getId());

        TUType courageous = new TUType("Courage", "Not deterred by authority");
        em.persist(courageous);
        tuTypeIdList.add(courageous.getId());

        TUType collaboration = new TUType("Collaboration", "Work well with others");
        em.persist(collaboration);
        tuTypeIdList.add(collaboration.getId());

        TUType dedication = new TUType("Dedication", "Committed and driven to a purpose");
        em.persist(dedication);
        tuTypeIdList.add(dedication.getId());

        TUType influence = new TUType("Influence", "Authoritative and persuasive");
        em.persist(influence);
        tuTypeIdList.add(influence.getId());

        TUType dependable = new TUType("Dependability", "Able to be relied on");
        em.persist(dependable);
        tuTypeIdList.add(dependable.getId());

        TUType ambition = new TUType("Ambition", "Strong desire to succeed");
        em.persist(ambition);
        tuTypeIdList.add(ambition.getId());

        TUType egalitarianism = new TUType("Egalitarianism", "Believe in fairness and equality");
        em.persist(egalitarianism);
        tuTypeIdList.add(egalitarianism.getId());

        TUType resilient  = new TUType("Resilience ", "Able to endure difficulty");
        em.persist(resilient );
        tuTypeIdList.add(resilient .getId());

        TUType productive = new TUType("Productivity", "Delivering more consistently");
        em.persist(productive);
        tuTypeIdList.add(productive.getId());

        TUType respectful = new TUType("Respectfulness", "Believe in fairness and equality");
        em.persist(respectful);
        tuTypeIdList.add(respectful.getId());

        TUType nurturing = new TUType("Nurture", "Encourage growth and development");
        em.persist(nurturing);
        tuTypeIdList.add(nurturing.getId());

        TUType competence = new TUType("Competence", "Ability to do something successfully");
        em.persist(competence);
        tuTypeIdList.add(competence.getId());

        TUType grit = new TUType("Grit", "Resolve and character to persevere");
        em.persist(grit);
        tuTypeIdList.add(grit.getId());

        TUType mastery = new TUType("Mastery", "Eagerness to add to own knowledge base");
        em.persist(mastery);
        tuTypeIdList.add(mastery.getId());

        TUType selfDirection = new TUType("Self-direction", "Willing to make decisions on direction and goals");
        em.persist(selfDirection);
        tuTypeIdList.add(selfDirection.getId());

        TUType confidence = new TUType("Confidence", "Self-assured and poised");
        em.persist(confidence);
        tuTypeIdList.add(confidence.getId());

        TUType independentThinking = new TUType("Independent Thinking", "Having own innovative ideas");
        em.persist(independentThinking);
        tuTypeIdList.add(independentThinking.getId());

        TUType responsibility = new TUType("Responsibility", "Strong sense of ownership");
        em.persist(responsibility);
        tuTypeIdList.add(responsibility.getId());

        TUType leadership = new TUType("Leadership", "Having the X-factor for leading");
        em.persist(leadership);
        tuTypeIdList.add(leadership.getId());

        TUType teamSpirit = new TUType("Team Spirit", "Having qualities for thriving in team env.");
        em.persist(teamSpirit);
        tuTypeIdList.add(teamSpirit.getId());

        TUType attnToDetal = new TUType("Attn. to Detail", "Mindfulness of important detail");
        em.persist(leadership);
        tuTypeIdList.add(leadership.getId());

        TUType culturalFit  = new TUType("Cultural Fit", "Suitability based on company values");
        em.persist(leadership);
        tuTypeIdList.add(leadership.getId());

        TUType multiSkilled  = new TUType("Multi-skilled", "Broad knowlege and skill");
        em.persist(multiSkilled);
        tuTypeIdList.add(multiSkilled.getId());

        TUType completion  = new TUType("Completion", "Ability to bring tasks to successful completion");
        em.persist(completion);
        tuTypeIdList.add(completion.getId());

        //TUComposite
        TUComposite nike1 = new TUComposite("1", "Nike", true);
        em.persist(nike1);

        TUComposite nike2 = new TUComposite("1", "Disney", false);
        em.persist(nike2);

        //TU
        TU tuIntelligence = new TU(nike1.getId(), intelligence.getId(),25);
        em.persist(tuIntelligence);

        TU tuPositivity = new TU(nike1.getId(), positivity.getId(),25);
        em.persist(tuPositivity);

        TU tuGoodJudgement = new TU(nike1.getId(), goodJudgement.getId(),25);
        em.persist(tuGoodJudgement);

        TU tuOpenness = new TU(nike1.getId(), openness.getId(),25);
        em.persist(tuOpenness);

    }


    /*-------------------*/


  @GET
  @Path("initdb/{corpID}/{userToken}")
  @Produces("text/html")
  public String initDB(@PathParam("corpID") String corpID, @PathParam("userToken") String userToken) {

  	if (!validUserAndLevel(corpID, userToken, null,"101"))
		return "ERROR: Unauthorized";

// ***Read in csv file with members
    String csvFile = "C:\\Docs\\Humayun\\Code\\Data\\members.csv";
    String line;
    String csvSplitBy = ",";
    int i=0;
    Member member = new Member(), mergedMember = new Member();

    java.util.ArrayList<String> tuTypeIdList = new java.util.ArrayList <>(); //hold tutypes to randomly assign to starsgiven

    String deptId[] = new String[6];
    Random rand = new Random();

      //Add Corporations
      Corp corp1 = new Corp("Sierra Club", "http://www.sierraclub.org/");
      em.persist(corp1);

      Corp corp2 = new Corp("Google, Inc.", "http://www.google.org/");
      em.persist(corp2);

      Corp corp3 = new Corp("Washington Post", "http://www.washingtonpost.org/");
      em.persist(corp3);

	  //Add departments to one of the corporations
      DeptCorp deptCorp1 = new DeptCorp("Marketing", corp1.getId());
      em.persist(deptCorp1);
      deptId[0] = deptCorp1.getId();
      em.flush();

      DeptCorp deptCorp = new DeptCorp("Sales", corp1.getId());
      DeptCorp dc = em.merge(deptCorp);
      em.flush();
      deptId[1] = dc.getId();
      deptCorp.setCorpID(corp1.getId()); deptCorp.setDeptName("Engineering");
      dc = em.merge(deptCorp);
      deptId[2] = dc.getId();
      em.flush();
      deptCorp.setCorpID(corp1.getId()); deptCorp.setDeptName("Finance & Accounting");
      dc = em.merge(deptCorp);
      em.flush();
      deptId[3] = dc.getId();
      deptCorp.setCorpID(corp1.getId()); deptCorp.setDeptName("General");
      dc = em.merge(deptCorp);
      em.flush();
      deptId[4] = dc.getId();

      deptCorp.setCorpID(corp2.getId()); deptCorp.setDeptName("Professional Services");
      dc = em.merge(deptCorp);
      em.flush();
      deptId[5] = dc.getId();

	  //Add allowable url's to couple of corporations
      CorpAllowedURLs corpAllowedURLs1 = new CorpAllowedURLs(corp1.getId(), "thelake.com");
	  em.persist(corpAllowedURLs1);
      CorpAllowedURLs corpAllowedURLs2 = new CorpAllowedURLs(corp1.getId(), "yahoo.com");
	  em.persist(corpAllowedURLs2);
      CorpAllowedURLs corpAllowedURLs3 = new CorpAllowedURLs(corp2.getId(), "google.com");
	  em.persist(corpAllowedURLs3);

      //Add roles to ROLE table
      Role _super = new Role("101", "SUPER", "The owner of the whole instance");
      em.persist(_super);
      Role corpAdmin = new Role("201", "CORP-ADMIN", "Admin per corporate contract");
      em.persist(corpAdmin);
      Role deptAdmin = new Role("301", "DEPT-ADMIN", "Admin per department within corporate contract");
      em.persist(deptAdmin);
      Role user = new Role("401", "USER", "User within a department");
      em.persist(user);

      String fullHash=""; //encrypt supplied password into this format -> algorithm:iterations:hashSize:salt:hash
      String[] hashChunk = new String[5] ;  //[algorithm][iterations][hashSize][salt][hash]
      String hashLopped=""; //remove the hashed password (hash) from the end -> algorithm:iterations:hashSize:salt
      String vcode="";

      try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
              Random randDeptIdx = new Random();
          while ((line = br.readLine()) != null) {
            String[] memberInfo = line.split(csvSplitBy);

            member.setnameFirst(memberInfo[0]);
            member.setnameMiddle(memberInfo[1]);
            member.setnameLast(memberInfo[2]);
            member.setUserID("test"+Integer.toString(rand.nextInt(1000000))+"@yahoo.com");
            member.setCorpID(corp1.getId());
            do{
                try {fullHash = Encryption.createHash("passpass");} catch (Encryption.CannotPerformOperationException e){return e.getMessage();};
                hashChunk = fullHash.split(":");
                hashLopped = fullHash.substring(0,fullHash.lastIndexOf(':'));
                vcode = hashChunk[Encryption.PBKDF2_INDEX].substring(hashChunk[Encryption.PBKDF2_INDEX].length()-5);
            }while (vcode.contains("+") || vcode.contains("/"));

            member.setPWD(hashChunk[Encryption.PBKDF2_INDEX]);
            member.setHash(hashLopped);
            member.setEmail("test@test.com");
            member.setDepartmentID(deptId[randDeptIdx.nextInt(5)]);
            member.setRoleID(user.getId());
            member.setActive(true);
            mergedMember = em.merge(member);
			em.persist(mergedMember);
            em.flush();
			em.clear();
            i++;
          }
		  //Add default department admin user with known password
            member.setnameFirst("Henry");
            member.setnameMiddle("David");
            member.setnameLast("Thoreau");
            member.setUserID("alone@thelake.com");
            member.setCorpID(corp1.getId());
            member.setPWD("/KkktlFEaVRL3HLWD2cRHfJ4");
            member.setHash("sha1:64000:18:hNjFOwfhe45D2WCih7vQLgsQ71KCrtuD");
            member.setEmail("alone@thelake.com");
            member.setDepartmentID(deptId[0]);
            member.setRoleID(corpAdmin.getId());
            member.setActive(true);
            mergedMember = em.merge(member);
			em.persist(mergedMember);
			em.flush();

            member.setnameFirst("Hugh");
            member.setnameMiddle("H:"+Integer.toString(rand.nextInt(1000000)));
            member.setnameLast("Khan");
            member.setUserID("hughkhan@yahoo.com");
            member.setCorpID(corp1.getId());
            em.persist(member);
//            mergedMember = em.merge(member);
//			em.persist(mergedMember);
//			em.flush();

            addQualities(tuTypeIdList);

      } catch (PersistenceException pe) {
        return "<html lang=\"en\"><body><h1>  ERROR:  " + pe.getMessage() + "  </h1></body></html>";
      } catch (IOException e) {
		return "<html lang=\"en\"><body><h1>  ERROR:  " + e.getMessage() + "  </h1></body></html>";
      }

// *** Add stars given sample data using random number generator.  Expects member ID to be sequential from 1 to max member count
    int memberCount = ((Number)em.createNamedQuery(Member.COUNT).getSingleResult()).intValue();

      //import java.util.concurrent.ThreadLocalRandom;
      //ThreadLocalRandom.current().nextInt(min, max + 1);
      //or
      //Min + (int)(Math.random() * ((Max - Min) + 1))

    Calendar calendar = Calendar.getInstance();
    java.util.Date now = calendar.getTime();
    StarGiven starGiven = new StarGiven();

    for (i=0; i < 1000; i++)
    {
      starGiven.setGivenDate(now);
      starGiven.setGivingMemberID(Integer.toString(rand.nextInt(memberCount) + 8 + 1)); //auto generate id (assuming sequential from 1-max) +8 for sequence counter increase from above
      starGiven.setReceivingMemberID(Integer.toString(rand.nextInt(memberCount) + 8 + 1)); //auto generate id (designed to work only when starting from empty db)
      starGiven.setTuTypeID(tuTypeIdList.get(rand.nextInt(48)));
      em.merge(starGiven);
      em.flush();
    }

    return "<html lang=\"en\"><body><h5>"+hashChunk[Encryption.PBKDF2_INDEX]+"--"+
            hashChunk[Encryption.PBKDF2_INDEX].substring(hashChunk[Encryption.PBKDF2_INDEX].length()-5)
            +"---"+ Integer.toString(i) + " Database Records Added. Total number of members = " + memberCount +"</h5></body></html>";
  }




  /*--------------------------*/

    @POST
    @Path("qualityprofile")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String qualityProfile(String message) {
        String[] msgChunk = message.split(",");                         //0=corpID,1=userToken,2=param,3=param
        String  corpID  	= msgChunk[0],                          //corpID
                userToken   = msgChunk[1],                          //userToken
                param   	= msgChunk[2];                          //param (add/update/delete)
		try{
			if (!validUserAndLevel(corpID, userToken, null,"201"))
			return "ERROR: Unauthorized";
		
			if (param.equalsIgnoreCase("update")){
				String activeProfileId = msgChunk[3];                   //profile ID that is to be made active
			   em.createNativeQuery("update tucomposite set active=false where corpid = '" + corpID + "'").executeUpdate();
			   em.createNativeQuery("update tucomposite set active=true where corpid = '" + corpID + "' and id = '" + activeProfileId + "'").executeUpdate();
			}
			else if (param.equalsIgnoreCase("add")){
				String newProfileName = msgChunk[3];                    //New profile name
				TUComposite tuc = new TUComposite(corpID, newProfileName, false);
				em.persist(tuc);
			}
			else if (param.equalsIgnoreCase("delete")){
				String profileIdToDelete = msgChunk[3];                 //id of the profile to delete

				em.createNativeQuery("DELETE FROM tu WHERE tucompositeid = '" + profileIdToDelete + "'").executeUpdate();

			
				TUComposite tuc = em.find(TUComposite.class, profileIdToDelete);
				if (tuc != null)
					em.remove(tuc);
				else
					return "ERROR";
			}
        } catch (PersistenceException pe) {
            return "FAIL: " + pe.getMessage();
        }
        return "SUCCESS";
    }
  /*--------------------------*/

    @POST
    @Path("quality")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String quality(String message) {                                     //0=corpID,1=userToken,2=param1,3=param2,4=param3
        String[] msgChunk = message.split(",");
        String  corpID      = msgChunk[0],                                      //corpID
                userToken   = msgChunk[1],                                      //userToken
                param       = msgChunk[2];                                      //param (add/update/delete)
		try{
			if (!validUserAndLevel(corpID, userToken, null,"201"))
			return "ERROR: Unauthorized";

			if (param.equalsIgnoreCase("update")){

                if (msgChunk[3].isEmpty())
			        return "ERROR:TU_ID_EMPTY";

				TU tu = em.find(TU.class, msgChunk[3]);                         //2=TU ID which is the primary key
				if (tu != null){
				    TUType tutype = em.find(TUType.class, tu.getTutypeId());

				    if (tutype.getName().equalsIgnoreCase("General"))
				        return "ERROR:CANNOT_MODIFY_GENERAL";

					tu.setRatio(Math.round(Float.parseFloat(msgChunk[4])));         //3=ratio to be updated.  Only allow ratio to be updated
					em.persist(tu);
				}
				else
					return "ERROR:BAD_QUALITYTYPEID";
			}
			else if (param.equalsIgnoreCase("add")){
				String profileId = msgChunk[3];                                                         //2=Associated profile ID
				String qualityTypeId = msgChunk[4];                                                     //3=Associated quality ID

                //if chose "General" from the quality list
                TUType tutype = em.find(TUType.class, qualityTypeId);
                if (tutype != null){
    			    if (tutype.getName().equalsIgnoreCase("General"))
	    		        return "ERROR:CANNOT_MODIFY_GENERAL";
                }
                else
                    return "ERROR:BAD_QUALITYTYPEID";

                //See if zero qualities in the profile.  If so then add "General" by default
                List<Object[]> tus = em.createNamedQuery(TU.FIND_ALL_BY_TUCOMPOSITEID_JOIN).setParameter("tucompositeid", profileId).getResultList();

                if (tus.size() == 0){
                    TUType tuTypeGeneral = em.createNamedQuery(TUType.FIND_GENERAL,TUType.class).getSingleResult();
                    TU tuGeneral = new TU(profileId, tuTypeGeneral.getId(), 0);
                    em.persist(tuGeneral);
                }

                //Now add the quality the admin chose
                TU tuNew = new TU(profileId, qualityTypeId, Math.round(Float.parseFloat(msgChunk[5])));    //4=ratio
				em.persist(tuNew);
			}
			else if (param.equalsIgnoreCase("delete")){

				TU tu = em.find(TU.class, msgChunk[3]);                 //2=TU ID which is the primary key

				if (tu != null){
				    TUType tutype = em.find(TUType.class, tu.getTutypeId());

				    if (tutype.getName().equalsIgnoreCase("General"))
				        return "ERROR:CANNOT_MOD_GENERAL";

					em.remove(tu);
                }
				else
					return "ERROR:BAD_QUALITYTYPEID";
			}
        } catch (PersistenceException pe) {
            return "FAIL: " + pe.getMessage();
        }
        return "SUCCESS";
    }
  /*--------------------------*/

    @GET
    @Path("givestar/{corpID}/{userToken}/{givingMemberID}/{receivingMemberID}/{qualityID}")
    @Produces("text/html")
    public Response giveStar(
            @PathParam("corpID") String corpID,
            @PathParam("userToken") String userToken,
            @PathParam("givingMemberID") String givingMemberID,
            @PathParam("receivingMemberID") String receivingMemberID,
            @PathParam("qualityID") String qualityID) {


        if (!validUserAndLevel(corpID, userToken, givingMemberID,"401"))
            return Response.status(403)
                            .entity("<html lang=\"en\"><body> ERROR: Unauthorized <br></body></html>")
                            .build();

        Calendar calendar = Calendar.getInstance();	                    //create a java calendar instance
        java.util.Date now = calendar.getTime();	                    //get a java.util.Date from the calendar instance. this date will represent the current instant, or "now".
        //java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());  //a java current time (now) instance


/*    ----CLOSURE EXAMPLE
      results.stream().forEach((record) -> {
        String firstName = (String) record[0];
        String lastName = (String) record[1];
      });*/

        try {
            StarGiven starGiven = new StarGiven(givingMemberID, receivingMemberID, qualityID, now);
            em.persist(starGiven);

        } catch (PersistenceException pe) {
            return Response.status(500)
                            .entity("<html lang=\"en\"><body><h1>  ERROR:  " + pe.getMessage() + "  </h1></body></html>\"")
                            .build();
        }

        return Response.status(200)
                        .entity("<html lang=\"en\"><body> SUCCESS <br></body></html>")
                        .build();
    }

  /*--------------------------*/

//  @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
//  @Produces({"application/xml", "application/json"})
//  @Consumes("text/plain") //Content-Type header in the POST
//  @Consumes({"text/plain,text/html"}) --working
//  @Produces({"application/xml", "application/json"}) --working
//  @Consumes("application/json") --working

  @POST
  @Path("addmember")
//  @Consumes(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.TEXT_PLAIN)
  @Produces(MediaType.TEXT_PLAIN)
  public String addMember(String message) {
    String csvSplitBy = ",";
    String[] msgChunk = message.split(csvSplitBy);      //0=nameFirst,1=nameMiddle,2=nameLast,3=corpID,4=uid,5=pwd,6=email,7=dept,8=role,9=active,10=userToken(optional)
    String uidLC = msgChunk[4].toLowerCase();           //store uid in lowercase
    boolean active = msgChunk[9].equals("ACTIVE");      //if ACTIVE then userToken is passed.  From Admin Container
    String corpID = msgChunk[3];

    if (active && !validUserAndLevel(corpID, msgChunk[10], null,"301"))
        return "FAIL";

    if (corpID.equalsIgnoreCase("NOCORPIDYET"))     //User is registering
        corpID = _getCorpIDFromUID(msgChunk[4]);

    try{
        String fullHash, hashLopped, activationCode = "";
        String[] hashChunk = new String[5];

        do{ 																//Loop until no query parameter messy characters are in the activationCode
            fullHash = Encryption.createHash(msgChunk[5]); 					//encrypt supplied password into this format -> algorithm:iterations:hashSize:salt:hash
            hashChunk = fullHash.split(":");  								//[algorithm][iterations][hashSize][salt][hash]
            hashLopped = fullHash.substring(0,fullHash.lastIndexOf(':')); 	//remove the hashed password (hash) from the end -> algorithm:iterations:hashSize:salt
            activationCode = hashChunk[Encryption.PBKDF2_INDEX].substring(hashChunk[Encryption.PBKDF2_INDEX].length()-5);
        }while (activationCode.contains("+") || activationCode.contains("/"));

        Role role = em.createNamedQuery(Role.FIND_BY_NAME, Role.class).setParameter("name", msgChunk[8]).getSingleResult();

        Member member = new Member(msgChunk[0],msgChunk[1],msgChunk[2],corpID,         			//msgChunk0=nameFirst,1=nameMiddle,2=nameLast,3=corpID
            uidLC,hashChunk[Encryption.PBKDF2_INDEX],hashLopped,msgChunk[6],msgChunk[7],role.getId(), 	//UID,PWD,seed,6=email,7=departmentID,roleID
            active, activationCode);																		//active(bool), activationCode
        em.persist(member);

        if (!active){
            String retStr = sendMailTLS(msgChunk[4]+","+msgChunk[0]+" "+msgChunk[2]+","+_getCorpNameFromID(corpID)+","+activationCode+","+"Not Testing");
            if (retStr.substring(0,7).equalsIgnoreCase("SUCCESS"))
                return "SUCCESS";
            else
                return "FAIL";
		}

		return "SUCCESS";

    } catch (EntityExistsException pe) {
        return  "Duplicate Record: " + pe.getMessage();
    } catch (PersistenceException pe) {
        return  "Error: " + pe.getMessage();
    } catch (Encryption.CannotPerformOperationException ex) {
        return "Encryption Failure";
    } catch (Exception e) {
        return  "General Error: " + e.getMessage();
    }
  }

    /*--------------------------*/

    @POST
    @Path("userinfo")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String userInfo(String message) {
    String[] msgChunk = message.split(","); //0=corpID,1=userToken,2=ID,3=param,4=first,5=middle,6=last,7=email
        String  corpID  	= msgChunk[0],
                userToken   = msgChunk[1],
                ID      	= msgChunk[2],
                param   	= msgChunk[3];
				
        if (!validUserAndLevel(corpID, userToken, null,"401"))
			return "ERROR:  Not Authorized";
		
        try{
            TypedQuery<Member> query = em.createNamedQuery(Member.FIND_BY_ID, Member.class).setHint(QueryHints.CACHE_USAGE, CacheUsage.DoNotCheckCache).setParameter("id",ID);
            Member member = query.getSingleResult();

            if(param.equals("get")){
                String retStr="{\"user\": ";
                retStr += "{\"ID\": \"" + member.getId()+
                        "\", \"nameFirst\": \"" + member.getnameFirst() +
                        "\", \"nameMiddle\": \"" + member.getnameMiddle() +
                        "\", \"nameLast\": \"" + member.getnameLast() +
                        "\", \"userID\": \"" + member.getUserID() +
                        "\", \"corpID\": \"" + member.getCorpID() +
                        "\", \"email\": \"" + member.getEmail() +
                        "\", \"department\": \"" + member.getDepartmentID() +
                        "\", \"roleID\": \"" + member.getRoleID() +
                        "\", \"active\": \"" + member.getActive() +
                        "\"}";
                retStr += "}";
                return retStr;
            }
            else if (param.equals("set")){
                if (!corpID.equals(member.getCorpID()))
                    return "ERROR: Corp ID does not match!";
                else{
                    member.setnameFirst(msgChunk[4]);
                    member.setnameMiddle(msgChunk[5]);
                    member.setnameLast(msgChunk[6]);
                    member.setEmail(msgChunk[7]);
                    em.persist(member);
                    return "SUCCESS";
                }
            }
            else
                return "ERROR:  wrong param or param missing";

        } catch (PersistenceException pe) {
            return "ERROR: " + pe.getMessage();
        }
    }

    /*--------------------------*/

    @POST
    @Path("changepwd")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String changePwd(String message) {
    String[] msgChunk = message.split(","); //0=corpID,1=userToken,2=ID,3=check/nockeck4=oldpwd,5=newpwd
        String  corpID  	= msgChunk[0], //not using.  ID's are unique across the whole database
                userToken   = msgChunk[1],
                ID      	= msgChunk[2];
        boolean check   	= msgChunk[3].equals("check");
        String  oldPwd  	= msgChunk[4],
                newPwd  	= msgChunk[5];

		if (check && !validUserAndLevel(corpID, userToken, null,"401"))
			return "ERROR:  Not Authorized";
		
		if (!check && !validUserAndLevel(corpID, userToken, null,"301"))
			return "ERROR:  Not Authorized";
		
        try{
            TypedQuery<Member> query = em.createNamedQuery(Member.FIND_BY_ID, Member.class).setHint(QueryHints.CACHE_USAGE, CacheUsage.DoNotCheckCache).setParameter("id",ID);
            Member member = query.getSingleResult();
			
            if (check && !Encryption.verifyPassword(oldPwd, member.getHash()+":"+member.getPWD()))  //algorithm:iterations:hashSize:salt:hash (hash is the encrypted pwd)
                return "FAIL:  Old password did not match";

            String fullHash, hashLopped, activationCode = "";
            String[] hashChunk = new String[5];

            fullHash = Encryption.createHash(newPwd); 					        //encrypt supplied password into this format -> algorithm:iterations:hashSize:salt:hash
            hashChunk = fullHash.split(":");  							    //[algorithm][iterations][hashSize][salt][hash]
            hashLopped = fullHash.substring(0,fullHash.lastIndexOf(':'));    //remove the hashed password (hash) from the end -> algorithm:iterations:hashSize:salt

            member.setPWD(hashChunk[Encryption.PBKDF2_INDEX]);
            member.setHash(hashLopped);
            em.persist(member);

            byte[] encodedPWD = Base64.getEncoder().encode(hashChunk[Encryption.PBKDF2_INDEX].getBytes());
            return "SUCCESS:"+(new String(encodedPWD));

        } catch (Encryption.CannotPerformOperationException|Encryption.InvalidHashException ex) {
            return "FAIL: Encryption Failure";
        } catch (PersistenceException pe) {
            return "FAIL: " + pe.getMessage();
        }
    }

 /*--------------------------*/

    @POST
    @Path("inactivateuser")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String inactiveUser(String message) {
    String[] msgChunk = message.split(","); //0=corpID,1=userToken,2=ID
        String  corpID  	= msgChunk[0], //not using.  ID's are unique across the whole database
                userToken   = msgChunk[1],
                ID      	= msgChunk[2];
				
		if (!validUserAndLevel(corpID, userToken, null,"301"))
			return "ERROR:  Not Authorized";
		
        try{
            Member member = em.createNamedQuery(Member.FIND_BY_ID, Member.class).setHint(QueryHints.CACHE_USAGE, CacheUsage.DoNotCheckCache).setParameter("id",ID).getSingleResult();
            if (member.getActive())
                member.setActive(false);
            else
                member.setActive(true);

            em.persist(member);

        } catch (PersistenceException pe) {
            return "FAIL: " + pe.getMessage();
        }
        return "SUCCESS";
        }

 /*--------------------------*/

    @POST
    @Path("changeuserdept")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String changeUserDept(String message) {
    String[] msgChunk = message.split(","); //0=corpID,1=userToken,2=ID,3=toDept
        String  corpID  	= msgChunk[0],
                ID      	= msgChunk[1],
                userToken   = msgChunk[2],
                toDept  	= msgChunk[3];

		if (!validUserAndLevel(corpID, userToken, null,"301"))
			return "ERROR:  Not Authorized";				

        try{
            Member member = em.createNamedQuery(Member.FIND_BY_ID, Member.class).setHint(QueryHints.CACHE_USAGE, CacheUsage.DoNotCheckCache).setParameter("id",ID).getSingleResult();
            List<DeptCorp> deptList = em.createNamedQuery(DeptCorp.FIND_ALL_BY_CORPID, DeptCorp.class).setParameter("corpID", corpID).getResultList();

            //Find the department record matching DEPTNAME=toDept
            int deptIdx = 0;
            for (;deptIdx<deptList.size();deptIdx++)
                if (deptList.get(deptIdx).getDeptName().equals(toDept)) break;

            if (deptIdx == deptList.size())
                return "FAIL: Department name " + toDept + " not found.";

            member.setDepartmentID(deptList.get(deptIdx).getId());
            em.persist(member);

        } catch (PersistenceException pe) {
            return "FAIL: " + pe.getMessage();
        }
        return "SUCCESS";
        }

    /*--------------------------*/

    @POST
    @Path("deptadmin")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String deptAdmin(String message) {
    String[] msgChunk = message.split(","); //0=corpID,1=userToken,2=deptID/deptName,3=deptName(optional)
        String  corpID      = msgChunk[0],
                userToken   = msgChunk[1],
                operation   = msgChunk[2];

		if (!validUserAndLevel(corpID, userToken, null,"201"))
			return "ERROR:  Not Authorized";				

        try{
            if (operation.equalsIgnoreCase("add")){
                String deptName = msgChunk[3];
                if ((deptName == null || deptName.isEmpty())) return "FAIL:BLANK_FIELD";

                DeptCorp department = new DeptCorp(deptName, corpID);
                em.persist(department);
            }else if (operation.equalsIgnoreCase("delete")){
                String deptID = msgChunk[3];
                if ((deptID == null || deptID.isEmpty())) return "FAIL:BLANK_FIELD";

                String queryStr = "select count(id) from member where departmentid = '" + deptID + "'";
                int memberCount = ((Number)em.createNativeQuery(queryStr).getSingleResult()).intValue();
                if (memberCount > 0){
                    return "FAIL: DEPT_NOT_EMPTY";
                }
                else{
                    DeptCorp departmentToDelete = em.find(DeptCorp.class, deptID);
                    em.remove(departmentToDelete);
                }
            }else if (operation.equalsIgnoreCase("rename")){
                String deptID = msgChunk[3], deptName = msgChunk[4];
                if ((deptID == null || deptID.isEmpty() || deptName == null || deptName.isEmpty())) return "FAIL:BLANK_FIELD";

                DeptCorp departmentToRename = em.find(DeptCorp.class, deptID);
                departmentToRename.setDeptName(deptName);
                em.persist(departmentToRename);
            }

        } catch (PersistenceException pe) {
            return "FAIL: " + pe.getMessage();
        }
        return "SUCCESS";
        }


    /*--------------------------*/

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String loginMember(String message) {
        String csvSplitBy = ",";
        String[] msgChunk = message.split(csvSplitBy); //msgChunk[0]=uid, msgChunk[1]=pwd
        try{
//            TypedQuery<Member> query = em.createNamedQuery(Member.FIND_BY_UID, Member.class).setParameter("uid",msgChunk[0].toLowerCase());
            TypedQuery<Member> query = em.createNamedQuery(Member.FIND_BY_UID, Member.class).setHint(QueryHints.CACHE_USAGE, CacheUsage.DoNotCheckCache).setParameter("uid",msgChunk[0].toLowerCase());

            Member loggingMember = query.getSingleResult();

            if (!loggingMember.getActive())
                return "NOT ACTIVE";

            if (!Encryption.verifyPassword(msgChunk[1], loggingMember.getHash()+":"+loggingMember.getPWD()))  //algorithm:iterations:hashSize:salt:hash (hash is the encrypted pwd)
                return "FAIL";

            Role role = em.find(Role.class, loggingMember.getRoleID()); //Retrieve record for roleID to get the "name" for the role

            TypedQuery<DeptCorp> dpquery = em.createNamedQuery(DeptCorp.FIND_BY_ID, DeptCorp.class).setParameter("id",loggingMember.getDepartmentID());
			DeptCorp deptcorp = dpquery.getSingleResult();

            TypedQuery<Corp> cquery = em.createNamedQuery(Corp.FIND_BY_ID, Corp.class).setParameter("id",deptcorp.getCorpID());
			Corp corp = cquery.getSingleResult();

            byte[] encodedPWD = Base64.getEncoder().encode(loggingMember.getPWD().getBytes());

            return "SUCCESS"+","+loggingMember.getId()+
                             ","+loggingMember.getUserID()+
                             ","+loggingMember.getnameFirst()+
                             ","+loggingMember.getnameMiddle()+
                             ","+loggingMember.getnameLast()+
                             ","+role.getName()+
                             ","+loggingMember.getDepartmentID()+
                             ","+deptcorp.getDeptName()+
                             ","+corp.getId()+
                             ","+corp.getName()+
//                             ","+role.getId()+
//							 ","+loggingMember.getPWD()+
                             ","+(new String(encodedPWD));


        } catch (NoResultException pe) {
            return "NO RESULT";
        } catch  (PersistenceException pe){
            return "ERROR: " + pe.getMessage();
        } catch (Exception e){
            return "ERROR: " + e.getMessage();
        }
    }


    /*--------------------------*/


  @POST
  @Path("validateemailp")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  public String validateEmailP(String message){
    String[] msgChunk = message.split(","); //0=uid,1=secureCode

    try{
        TypedQuery<Member> query = em.createNamedQuery(Member.FIND_BY_UID, Member.class).setParameter("uid",msgChunk[0].toLowerCase());
        Member loggingMember = query.getSingleResult();

//        if (secureCode.equals(loggingMember.getPWD().substring(loggingMember.getPWD().length()-5))){  //Note:  Don't really need to use the activation code key if using PWD substring
        if (msgChunk[1].equals(loggingMember.getActivationCode())){
            loggingMember.setActive(true);
            loggingMember.setActivationCode(null);
            em.persist(loggingMember);

            //remove this member record from cache so other clients are updated properly of the status
            Cache cache = em.getEntityManagerFactory().getCache();
            CorpUserPK memberPK = new CorpUserPK(loggingMember.getCorpID(),msgChunk[0]);
            cache.evict(Member.class, memberPK);

            return "VALID";
        }
        else
            return "FAIL";
    } catch (NoResultException pe) {
        return "NO RESULT";
    } catch  (PersistenceException pe){
        return "ERROR: " + pe.getMessage();
    } catch (Exception e){
        return "ERROR: " + e.getMessage();
    }
  }

    /*----------------------*/

  @GET
  @Path("validateemail")
  @Produces("text/html")
  public String validateEmail(@QueryParam("email") String uid,
                              @QueryParam("securecode") String secureCode){

    try{
        TypedQuery<Member> query = em.createNamedQuery(Member.FIND_BY_UID, Member.class).setParameter("uid",uid.toLowerCase());
        Member loggingMember = query.getSingleResult();

//        if (secureCode.equals(loggingMember.getPWD().substring(loggingMember.getPWD().length()-5))){  //Note:  Don't really need to use the activation code key if using PWD substring
        if (secureCode.equals(loggingMember.getActivationCode())){
            loggingMember.setActive(true);
            loggingMember.setActivationCode(null);
            em.persist(loggingMember);

            //remove this member record from cache so other clients are updated properly of the status
            Cache cache = em.getEntityManagerFactory().getCache();
            CorpUserPK memberPK = new CorpUserPK(loggingMember.getCorpID(),uid);
            cache.evict(Member.class, memberPK);

            return "VALID";
        }
        else
            return "FAIL";

/*        //Assemble full hash from secureCode.  secureCode is the last 5 chars from encrypted pwd(":hash" portion).  PWD field in the member table
        String encryptedPWD = loggingMember.getHash()                                                 //algorithm:iterations:hashSize:salt
                              +":"
                              +loggingMember.getPWD().substring(0,loggingMember.getPWD().length()-5)  //encrypted pwd minus last 5 chars
                              +secureCode;                                                            //last 5 chars of encrypted pwd

        if (!Encryption.verifyPassword(encryptedPWD, loggingMember.getHash()+":"+loggingMember.getPWD()))  //algorithm:iterations:hashSize:salt:hash (hash is the encrypted pwd)
            return "FAIL"+encryptedPWD;*/

    } catch (NoResultException pe) {
        return "NO RESULT";
    } catch  (PersistenceException pe){
        return "ERROR: " + pe.getMessage();
    } catch (Exception e){
        return "ERROR: " + e.getMessage();
    }
  }

  /*-----------------------------------------*/

//  @POST
//  @Path("sendmailtls")
//  @Consumes(MediaType.APPLICATION_JSON)
//  @Produces(MediaType.TEXT_PLAIN)
  public String sendMailTLS(String request) {

        String[] reqChunk = request.split(","); //0=to(userid/email),1=username,2=corpName,3=securitycode,4=testing

        String corpName = _getCorpNameFromID(_getCorpIDFromUID(reqChunk[0]));
        String _content;
//        try{
            _content = "Hello "+reqChunk[1]+",  <br><br>Please click this link to securely sign up for "
//                    +reqChunk[2]+" using Highplume.com --> <a href=\"http://192.168.100.169:8080/securecode?code="
//                    +reqChunk[3]+"\"> "
//                    +reqChunk[2]+" via Highplume.com</a>";

                    +corpName+" using Highplume. --> <a href=\"http://192.168.100.169/#/login?email="
                    +reqChunk[0]+"&securecode="+reqChunk[3]+"\"> "
                    +corpName+" via Highplume.com</a><br><br>"
                    + "If this is not you, please ignore this email.  The registrant might have mistyped her/his email.";

//                    +reqChunk[0]+"&securecode="+URLEncoder.encode(reqChunk[3],"UTF-8")+"\"> "
//        } catch (UnsupportedEncodingException e) {
//            throw new AssertionError("UTF-8 is unknown");
//        }

        if (reqChunk[4].equals("testing"))
    		return "SUCCESS: Testing, no message sent: " +_content;

//		final String username = "hughhkhan@gmail.com";
		final String username = "verify@highplume.com";
		final String password = "Catalog1";


		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress("hughhkhan@gmail.com"));
			message.setFrom(new InternetAddress("verify@highplume.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(reqChunk[0]));
			message.setSubject("Sign-up code");
//			message.setText("Dear Mail Crawler,"
//				+ "\n\n No spam to my email, please!");

			message.setContent(_content, "text/html");

			Transport.send(message);

			return "SUCCESS: Message Sent..."+_content;

		} catch (MessagingException e) {
//			throw new RuntimeException(e);
            return "ERROR:" + e.getMessage();
		}


  }

    /*--------------------------*/

  public boolean validUserAndLevel(String CorpID, String userTokenBase64, String userID, String minLevel) {  //userID='id' in member table
	try{
        byte[] decodedPWD = Base64.getDecoder().decode(userTokenBase64.getBytes());
        String userToken = new String(decodedPWD); log("validUserAndLevel:userToken: " + userToken,1);
		
		Member member = em.createNamedQuery(Member.FIND_BY_PWD, Member.class).setParameter("pwd",userToken).getSingleResult();
		Integer minLevelIntValue = Integer.valueOf(minLevel);
		Integer userRoleIntValue = Integer.valueOf(member.getRoleID());

		if (userID != null)
		    if (!(member.getId().equals(userID))){
				log("validUserAndLevel:userID != member.Id");
                return false;                           //ID did not match record pulled up using userToken.  Possible hack.
			}
		if (CorpID.equals(member.getCorpID())){
			if (userRoleIntValue <= minLevelIntValue)
				return true;
			else{
				log("validUserAndLevel:minLevel fail");
				return false;
			}
		}
		else
		{
			log("validUserAndLevel:corpID != member.corpID");
			return false;
		}
 	} catch (NoResultException pe) {
			log("validUserAndLevel:NoResultException: " + pe.getMessage());
            return false;
    } catch  (PersistenceException pe){
			log("validUserAndLevel:PersistenceException: " + pe.getMessage());
            return false;
    } catch (Exception e){
			log("validUserAndLevel:Exception: " + e.getMessage());
            return false;
    }
  }

    /*--------------------------*/

  public String getRoleValue (String roleName){

	switch(roleName) {
		case "USER" : return "401";
		case "DEPT-ADMIN" : return "301";
		case "CORP-ADMIN" : return "201";
		case "SUPER" : return "101";
		default : return "001";
	}
  }

    /*--------------------------*/

  public String getRoleName (String roleValue){

	switch(roleValue) {
		case "401" : return "USER";
		case "301" : return "DEPT-ADMIN";
		case "201" : return "CORP-ADMIN";
		case "101" : return "SUPER";
		default : return "ERROR";
	}
  }

    /*--------------------------*/

  public String _getCorpIDFromUID(String userID){

    String[] _messageChunks = userID.split("@");

	try{
		TypedQuery<CorpAllowedURLs> query = em.createNamedQuery(CorpAllowedURLs.FIND_CORPID_BY_URL, CorpAllowedURLs.class)
                .setParameter("allowedURL",_messageChunks[_messageChunks.length-1].toLowerCase());  //only compare the part after the @ sign
		CorpAllowedURLs corpAllowedURLs = query.getSingleResult();
		return corpAllowedURLs.getCorpID();

	} catch (NoResultException pe) {
            return "NO RESULT";
    } catch  (PersistenceException pe){
            return "ERROR: " + pe.getMessage();
    } catch (Exception e){
            return "ERROR: " + e.getMessage();
    }
  }

    /*--------------------------*/

  public String _getCorpNameFromID(String corpID){

	try{
		Corp corp = em.createNamedQuery(Corp.FIND_BY_ID, Corp.class).setParameter("id", corpID).getSingleResult();
		return corp.getName();

	} catch (NoResultException pe) {
            return "ERROR: NO RESULT";
    } catch  (PersistenceException pe){
            return "ERROR: " + pe.getMessage();
    } catch (Exception e){
            return "ERROR: " + e.getMessage();
    }
  }

}

/*

package com.mkyong.common;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailSSL {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("username","password");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from@no-spam.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("to@no-spam.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler," +
					"\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}*/


/*


  @POST
  @Path("sendmail")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  public String sendMail(String message) {

      String to = "sonoojaiswal1988@gmail.com";//change accordingly
      String from = "sonoojaiswal1987@gmail.com";//change accordingly
      String host = "localhost";//or IP address
      String[] _msgChunks = message.split(",");
     //Get the session object
      Properties properties = System.getProperties();
      properties.setProperty("mail.smtp.host", host);
      Session session = Session.getDefaultInstance(properties);

     //compose the message
      try{
         MimeMessage mailMessage = new MimeMessage(session);
         mailMessage.setFrom(new InternetAddress(from));
         mailMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
         mailMessage.setSubject("Ping");
         mailMessage.setText("Hello, this is example of sending email  ");

         // Send message
         Transport.send(mailMessage);
         return "message sent successfully....";

      }catch (MessagingException mex) {mex.printStackTrace(); return "Error";}
  }

 */