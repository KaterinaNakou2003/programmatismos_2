
# CodeCom

Καλώς ήρθατε στην _**CodeCom**_!
Η εφαρμογή μας απευθύνεται σε ένα ευρύ κοινό και ως στόχο έχει τη της γνώσης σε όλους μας τους χρήστες. 
Είναι ουσιαστικά μια ηλεκτρονική βιβλιοθήκη, στην οποία οι χρήστες μπορούν μέσω ποστ να απευθύνουν μια ερώτηση στους άλλους χρήστες ή να ποστάρουν μια γνώση που θέλουν να μοιραστούν, καθώς και να απαντήσουν σε άλλα ποστ.  
Ελπίζουμε να γινέτε και σείς το επομένο μέλος της κοινότητας _**CodeCom**_.  
>>_Με εκτίμηση οι δημιουργοί της!_
   

#### CodeCom: οδηγίες χρήσης   
Θες να γίνεις μέλος της κοινότητάς μας; Πληκτρολόγησε το 1.   
Θες να συνεδεθείς; Πληκτρολόγησε το 2.  
Ποια λειτουργία θες να χρησιμοποιήσεις :  
1.  Στείλε μήνυμα  
2.  Κάνε like  σε ένα άλλο μήνυμα  
3.  Απάντα σε ένα μήνυμα  
4.  Βγες από την εφαρμογή  
5.  Δες περαιτέρω οδηγίες   

Αν κατά λάθος πάτησες μια λειτουργία την οποία επιθυμείς να διακόψεις, πληκτρολόγησε exit και μετά πάτα το enter.      
Αν πάτησες να αποσυνδεθείς και τελικά το μετάνιωσες, δεν υπάρχει πρόβλημα.. Απλά πάτα n/N..


#### CodeCom:περιεχόμενα    
##### Κλάση User: 
Αποτελεί τη main κλάση της CodeCom.
Συνδέει όλες τις άλλες κλάσεις με αυτήν, μέσω των αντικειμένων.    
Ρωτάει τον χρήστη αν θέλει να εγγραφεί(1) ή να συνδεθεί(2).  
Αν ο χρήστης επιλέγει να εγγραφεί το σύστημα ζητάει από το χρήστη να εισάγει ενα ξεχωριστό όνομα-χρήστη και τον κωδικο του για να δημιουργήσει έναν λογαριασμό και επείτα συνδέεται στην εφαρμογή. Στη συνέχεια, το σύστημα εμφανίζει κάποιες οδηγίες ως προς το πώς να χρησιμοποιήσει ο χρήστης την εφαρμογή.   
Αν ο χρήστης επιλέγει να συνδεθεί το σύστημα ζητάει να εισάγει τα στοιχεία του και σε περίπτωση που είναι τα ίδια με αυτά που έχει δηλώσει στην δημιουργία του λογαριασμού του συνδέεται με αυτόν. Έπειτα, του εμφανίζει τα νέα του μηνύματα.      
Στη συνέχεια το σύστημα εμανίζει το κεντρικό μενού επιλογών στον χρήστη.     
Αν ο χρήστης επιλέξει τη λειτουργία 2 ή 3, το σύστημα εμφανίζει όλα τα μηνύματα της βάσης και ελέγχεται, μέσω της findLastMessage, άμα υπάρχει το μήνυμα που επέλεξε ο χρήστης.       
Όταν ο χρήστης επιθυμήσει να φύγει από την CodeCom, εισάγεται στον πίνακα το τελευταίο μήνυμα που υπάρχει εκείνη τη στιγμή στη βάση ως το τελευταίο μήνυμα που έχει δει. 

##### Κλάση Account:  
1. setUsername() :     
    Ο χρήστης δίνει τιμή στη μεταβλητή(String) username.
2. setPassword() :  
    Ο χρήστης δίνει τιμή στη μεταβλητή(String) password.
3. getUsername() :         
     Επιστρέφει την τιμή του username.  
4. getPassword() :       
     Επιστρέφει την τιμή του password.   
5. Account() :       
     Συνδέεται με τη βάση δεδομένων και περιέχει τα sql Statements τα οποία θα σταλθούν στην βάση για να εκτλεστούν.   
6. addAcount(String username, String password) :         
     i. Προσθέτει μια νέα εγγραφή στον πίνακα Users στη βάση δεδομένων.   
     ii. Επιστρέφει 1 σε περίπτωση που ήταν επιτυχής.   
7. checkUsername(String Username) :         
     i. Ελέγχει  σε περίπτωση που ο χρήστης θέλει να κάνει μια καινούρια εγγραφή να μην εισαχθεί στη βάση ο ίδιος λογαριασμός εφόσον υπάρχει ήδη και επιστέφει true οταν το username ήδη υπάρχει, ενώ όταν είναι ξεχωριστό επιστρέφει false.        
9. verifyAccount(String username, String password) :        
     i. Ελέγχει αν τα στοιχεία που έδωσε ο χρήστης ταιριάζουν με κάποια από αύτα που υπάρχουν στον πίνακα Users στη βάση δεδομένων
     και επιστρεφει true σε αυτη την περίπτωση, αντίθετα false.
     
##### Κλάση Message :  
1. getConnectionWithDB() :
          Σύνδεση της κλάσης με τη βάση  
3. sendMessage(String username, String answer) :
    1. Συνδέεται με τη βάση  
    2. Κάνει update του πίνακα Messages της βάσης μέσω της updateMessages  
    3. Μορφοποιεί κατάλληλα το μηνύμα που θα εμφανιστεί στον χρήστη όταν αυτός επιλέξει να στείλει μήνυμα  
4. getMessage(String username) :  
    1. Συνδέεται με τη βάση
    2. Βρίσκει το τελευταίο μήνυμα που υπάρχει στη βάση   
    3. Βρίσκει το τελευταίο μήνυμα που έχει δει ο χρήτσης. Αυτό φαίνεται στον πίνακα Logout της βάσης  
    3. Βρίσκει πόσα είναι τα νέα μηνύματα που δε έχει δει ο χρήστης και του τα εμφανίζει στην κατάλληλη μορφή  
5. reply(String username, String answer, int numberOfMessage) :  
    1. Συνδέεται με τη βάση  
    2. Κάνει update του πίνακα Messages της βάσης μέσω της updateMessages   
    3. Μορφοποιεί κατάλληλα το μηνύμα που θα εμφανιστεί στον χρήστη όταν αυτός επιλέξει να απαντήσει σε ένα μήνυμα 
6. printMessage() :  
    1. Εμφανίζει στον χρήστη μηνυμα, για να εισάγει το μήνυμα που επιθυμεί  
7. updateMessages(String username, String answer, int type) :  
    1. Κάνει update τον πίνακα Messages  
        + type == 0 : τo μήνυμα είναι απλό  
        + type == -1 : το μήνυμα είναι like    
        + αλλιώς το μήνυμα είναι reply 
8. findLastMessage(int y) :    
    1. Συνδέεται με τη βάση   
    2. Επιστρέφει :  
       + false, αν το μήνυμα που επιλέχθηκε δεν υπάρχει στη βάση  
       + true, αν το μήνυμα που επιλέχθηκε από τον χρήστη υπάρχει στη βάση  
9.  showMessages() : 
    1. Συνδέεται με τη βάση   
    2. Εμφανίζει όλα τα μηνύματα της βάσης
 
##### Κλάση Likes:  
1.  likedUser(int y) : 
    1. Συνδέεται με τη βάση   
    2. Βρίσκει τον χρήστη στου οποίου το μήνυμα θέλει ο χρήστης μας να κάνει like  
2.  messageBody(int y) :   
    1. Συνδέεται με τη βάση   
    2. Βρίσκει το περιεχόμενο του μηνύματος στο οποίο ο χρήστης θέλει να κάνει like  
3.  likeCounter(int y) :  
    1. Συνδέεται με τη βάση  
    2. Βρίσκει το σύνολο των likes που έχει το συγκεκριμένο μήνυμα  
4.  updateLikes(String username, String likedname, int y) :   
    1. Συνδέεται με τη βάση  
    2. Προσθέτει στον πίνακα Likes τα δεδομένα του καινούριου like
5.  connect db() :   
       Συνδέεται με τη βάση  

##### Κλάση Logout:  
1. getLogout(String answer) :  
    Αν ο χρήστης πατήσει ορθά να εξέλθει, εμφανίζεται σε αυτόν κατάλληλο μήνυμα και η μέθοδος επιστρέφει στο πρόγραμμα true. 
    Aν ο χρήστης πατήσει ότι δεν επιθυμεί να εξέλθει, η μέθοδος επιστρέφει στο πρόγραμμα false.
    Aν ο χρήστης πατήσει κάτι άλλο, καλείται η μέθοδος falseInput().
2. falseInput() :  
    Κάνει αναδρομή μέχρι ο χρήστης να πληκτρολογήσει από τις καθορισμένες επιλογές. 
    
#### CodeCom: διάγραμμα UML  
![διάγραμμα UML](https://github.com/KaterinaNakou2003/programmatismos_2/blob/main/image.png)  

#### CodeCom: δομές δεδομένων και αλγορίθμοι 
Η CodeCom χρησιμοποίει την εφαρμογή Microsoft SQL Management Studio (έκδοση v18.12.1) για τη δημιουργία της βάσης δεδομένων, στην οποία αποθηκεύονται τα δεδομένα της εφαρμογής μας.  
Η βάση περιέχει τους πινακες:  
1.   Users(username, password): Αποθηκύονται το username και ο κωδικός του χρήστη κατά την εγγραφή του και ανακτούνται όταν προσπαθεί να συνδεθεί, για να ταυτοποιηθούν τα στοιχεία του και να αποκτήσει πρόσβαση στον δικό του λογαριασμό - αν έχει δημιουργήσει. 
2.   Messages(message_id, sender, message_body, typeofmessage): Αποθηκεύεται το μοναδικό id του μηνύματος (ξεκινά από 1003 και προσαυξάνεται κάθε φορά κατά 1), το username του χρήστη που έστειλε το μήνυμα, το περιεχόμενο του μηνύματος (μέχρι 200 χαρακτήρες) και τέλος τον τύπο του μηνύματος: Ο αν πρόκεται για μήνυμα/ποστ, -1 όταν το μήνυμα αποτελεί like σε άλλο μήνυμα και οποιονδήποτε άλλο θετικό αριθμό που αντιστοιχεί στο message_id του μηνύματος στο οποίο απάντησε ο χρήστης όταν πρόκειται για reply . Όπως αναφέρθηκε παραπάνω, ο κώδικας αποτρέπει τον χρήστη από το να απαντήσει σε μήνυμα που ουσιαστικά είναι like.
3.   Likes(like_id, message_id, liked_user, liker): Αποθηκεύεται το μοναδικό like_id του μηνύματος (ξεκινά από 17 και προσαυξάνεται κατά 1), το messsage_id που υποδεικνύει το μήνυμα στο οποίο γίνεται το like, καθώς και ο χρήστης (το username) αυτού που κάνει το like.
4.   Logout(logout_id, username, lastmessageseen): Αποθηκεύει το μοναδικό logout_id του χρήστη (ξεκινά από 2008 και προσαυξάνεται κατά 1), το username αυτού που αποσυνδέεται από την εφαρμογή και το τελευταίο μήνυμα που διάβασε πριν αποσυνδεθεί, ώστε την επόμενη φορά που θα συνδεθεί θα μπορεί να δει τα μη αναγνωσμένα μηνύματα που έχει.    

Δεν χρησιμοποιήσαμε αλγορίθμους.

#### Οδηγίες μεταγλώττισης του προγράμματος
Στο command prompt και στο path του φακέλου CodeCom είναι απαραίτητο να ακολουθηθούν τα παρακάτω βήματα με σκοπό της δημιουργία του πακέτου jar της εφαρμογής μας.
Ακολουθούμε τον κύκλο ζωής της Maven με τις εντολές: mvn validate (Για να ελέγξουμε εαν το project είναι έγκαιρα δομημένο)
                                                    
         mvn compile
(Για να γίνει η μεταγλώττιση των κλάσεων που βρίσκονται στο path: CodeCom/src/main/java/com/CodeCom/app και επομένος η δημιουργία των .class αρχείων)
Σε αυτό το σημείο δημιουργείτε επίσης ο φάκελος target ο οποίος περιέχει τα παραγόμενα αρχεία. 
                                                     
         mvn test 
(Που εκτελεί τις κλάσεις ελέγχου του κώδικα. Το path όπου είναι τοποθετημένα είναι το εξής: CodeCom/src/test/java/com/CodeCom/app)
                                                     
         mvn package
(Εδώ γίνεται η "ένωση" όλων των αρχείων σε ένα jar, το οποίο βρίσκετε στο path: CodeCom/target)
                                                     
        mvn install 
(Σε αυτό το βήμα γίνεται η εγκατάσταση του παραγόμενου jar αρχείου σε ένα τοπικό αποθετήριο)
                                                      
#### Οδηγίες εκτέλεσης του προγράμματος
Απαραίτητη προϊπόθεση για την επιτυχή εκτέλεση της εφαρμογής μας είναι η δημιουργία της βάσης δεδομένων, όπου αποθηκεύονται όλα τα στοιχεία που χρειάζεται. Είναι κτισμένη μέσω του SQL Server Managment Studio άρα θα πρέπει να δημιουργήσετε την εκεί με το συγκεκριμένο σχήμα το οποίο βρήσκεται στον φάκελο CodeCom/src/main/java/com/CodeCom/app και είναι το αρχείο με όνομα  'CodecomQuery1'(Κάντε τις απαραίτητες αλλαγές σύμφωνα με τα σχόλια). Κάνοντας ένα απλό copy-paste σε ένα δικό σας query και εκτελόντας (execute) τις εντολές αυτές θα γίνει επιτυχώς η δημιουργία του σχήματος της βάσης δεδομένων.
Μετά την ολοκλήρωση του παραπάνω σταδίου θα πρέπει να τοποθετηθεί το σωστό (δικό σας) url της βάσης, έτσι ώστε να γίνει η σύνδεση του προγράμματος (εφαρμογής), στα εξής σημεία ύστερα απο το "jdbc:sqlserver://"    
User _γραμμή 21_   
Account _γραμμή 56_  
Likes _γραμμή 144_ &   
Message _γραμμή 22_   
Υπάρχουν δύο τρόποι εκτέλεσης της εφαρμογής και αυτοί περιγράφονται παρακάτω:       
   1ος τρόπος: Εφόσον έχει γίνει μεταγλώττιση στη φάση του compile (mvn compile),  μέσω cmd στο path .../CodeCom/target/classes με την εντολή java User για την έναρξη της εφαρμογής.                                                                                     
   2ος τρόπος: Εκτέλεση του jar αρχείου το οποίο δημιουργήθηκε με γνώμονα προηγούμενες οδηγίες που παρουσιάστηκαν.
Για να "τρέξει", δίνουμε την εντολή java -jar CodeCom-1.0-SNAPSHOT.jar (όπου CodeCom-1.0-SNAPSHOT το όνομα του παραγώμενου jar αρχείου.) στο φάκελο με path .../CodeCom/target ή στο τοπικό αποθετήριο που έχει γίνει η εγκατάστασή του. 
   3ος τρόπος: Στο Eclipse κάνοντας import ως maven project τον φάκελο CodeCom 
