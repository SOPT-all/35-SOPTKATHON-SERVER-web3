package sopt.web3.demo.service;

import org.springframework.stereotype.Service;
import sopt.web3.demo.dto.response.AllPercentageResponse;
import sopt.web3.demo.dto.response.TodoListsGetResponse;
import sopt.web3.demo.entity.Member;
import sopt.web3.demo.entity.TodoList;
import sopt.web3.demo.repository.MemberRepository;
import sopt.web3.demo.repository.TodoListRepository;

import java.util.List;

@Service
public class TodoListService {
    private final TodoListRepository todoListRepository;
    private final MemberRepository memberRepository;

    public TodoListService(TodoListRepository todoListRepository, MemberRepository memberRepository){
        this.memberRepository = memberRepository;
        this.todoListRepository = todoListRepository;
    }

    public TodoListsGetResponse getTodoLists(long memberId){
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("no member"));
        List<TodoList> todoLists = todoListRepository.findByMember(member);
        return TodoListsGetResponse.of(todoLists);
    }

    public AllPercentageResponse getAllPercentage(long memberId) {
        int allPercentage;
        int numCompleted = 0;
        int numAll = 0;
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("no member"));
        List<TodoList> todoLists = todoListRepository.findByMember(member);

        for(TodoList todo: todoLists){
            numCompleted += (todo.getNumCompleted() != null) ? todo.getNumCompleted() : 0;
            numAll += (todo.getNumAll() != null) ? todo.getNumAll() : 0;
        }

        if(numAll != 0){
            allPercentage = (100*numCompleted) / numAll;
        }else{
            allPercentage = 0;
        }
        return new AllPercentageResponse(allPercentage, numCompleted, numAll);
    }
}
