import org.springframework.test.web.servlet.MockMvc
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import static org.mockito.Mockito.*

class ReadinglistControllerTest {
    @Test
    void shouldReturnReadinglistFromRepository() {
        List<Book> expectedBooklist = new ArrayList<>();
        expectedBooklist.add(new Book(id: 1
            , reader: "craig"
            , isbn: "1234567890"
            , title: "Spring Boot in Action"
            , author: "Craig Walls"
            , description: "Spring Boot in Action is ..."))

        def mockRepo = mock(ReadinglistRepository.class)
        when(mockRepo.findByReader("craig")).thenReturn(expectedBooklist: mockRepo)

        def controller = new ReadinglistController(readinglistRepository: mockRepo)
        MockMvc mvc = standaloneSetup(controller).build()
        mvc.perform(get("/"))
            .andExpect(view().name("readingList"))
            .andExpect(model().attribute("books", expectedBooklist))
    }
}
