package br.com.amazingapps.playground.challenges

/**
 * Write code that receives the list representation and returns the Object representation
 *
 * Input:
 * [
 *   {id: 6, name: "Financial Analyst 1", parent_id: 3},
 *   {id: 4, name: "Engineering Manager 1", parent_id: 2},
 *   {id: 1, name: "CEO", parent_id: null},
 *   {id: 2, name: "CTO", parent_id: 1},
 *   {id: 3, name: "CFO", parent_id: 1},
 *   {id: 5, name: "Engineering Manager 2", parent_id: 2},
 *   {id: 7, name: "Engineer", parent_id: 4},
 * ]
 *
 * Output:
 * [
 *   {
 *     id: 1,
 *     name: "CEO",
 *     children: [
 *       {
 *         id: 2,
 *         name: "CTO",
 *         children: [
 *           {
 *             id: 4,
 *             name: "Engineering Manager 1",
 *             children: [{id: 7, name: "Engineer", children: []}]
 *           },
 *           {
 *             id: 5,
 *             name: "Engineering Manager 2",
 *             children: []
 *           }
 *         ]
 *       },
 *       {
 *         id: 3,
 *         name: "CFO",
 *         children: [{id: 6, name: "Financial Analyst 1", children: []}]
 *       }
 *     ]
 *   }
 * ]
 * */
fun main() {
    val input = listOf(
        Worker(id = 6, name = "Financial Analyst 1", parentId = 3),
        Worker(id = 4, name = "Engineering Manager 1", parentId = 2),
        Worker(id = 1, name = "CEO", parentId = null),
        Worker(id = 2, name = "CTO", parentId = 1),
        Worker(id = 3, name = "CFO", parentId = 1),
        Worker(id = 5, name = "Engineering Manager 2", parentId = 2),
        Worker(id = 7, name = "Engineer", parentId = 4),
    )

    val result = buildHierarchy(input)

    println(result)
}

fun buildHierarchy(workers: List<Worker>): List<Map<String, Any>> {
    val hierarchy = mutableListOf<Map<String, Any>>()
    val workerMap = workers.associateBy { it.id }

    val ceo = workerMap.values.find { it.parentId == null }

    ceo!!.let {
        val ceoNode = mutableMapOf(
            "id" to it.id,
            "name" to it.name,
            "children" to mutableListOf<Map<String, Any>>()
        )

        buildSubHierarchy(workerMap, ceoNode)
        hierarchy.add(ceoNode)
    }


    return hierarchy
}

fun buildSubHierarchy(workersMap: Map<Int, Worker>, parentNode: MutableMap<String, Any>) {
    val parentId = parentNode["id"] as Int
    val children = parentNode["children"] as MutableList<Map<String, Any>>
    val childrenWorkers = workersMap.values.filter { it.parentId == parentId }

    childrenWorkers.forEach {
        val child = mutableMapOf(
            "id" to it.id,
            "name" to it.name,
            "children" to mutableListOf<Map<String, Any>>()
        )

        children.add(child)
        buildSubHierarchy(workersMap, child)
    }
}

data class Worker(
    val id: Int,
    val name: String,
    val parentId: Int?
)
