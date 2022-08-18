package dev.alinda.myposts
//GENERIC FUNCTIONS
import retrofit2.http.POST
data class Post(
    var userId: Int,
    var id: Int,
    var title:String,
    var body:String)
data class Comment(
    var postId: Int,
    var id:Int,
    var name: String,
    var email:String,
    var body:String
    )

//generic functions(for comparing objects}
//fun compareComments(comment1: Comment, comment2: Comment):Comment{
//    return comment2
//}
// return sne f the two
//specifi func
//fun main (){
//    var post1=..
//    var post2=...
//
//    var comment1=..
//    var comment2=...
//
//    compareItems(post1,post2)
//    compareItems(comment1,comment2)
//}

// Call Back functions
//long running tasks(sending a req and getting a result,making a network call, or writing to a file / reading from a database locally)
// the app os xonstantly changing the ui so thats wat causes the application to stop
//for us to perform long running tasks we need to peform
//enqueue takes the request to another thread(input and output thread( where the request will be made to the server)
//we are requesting fr psots becauuse ww want to display them on the ui